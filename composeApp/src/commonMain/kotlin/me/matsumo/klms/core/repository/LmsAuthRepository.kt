package me.matsumo.klms.core.repository

import co.touchlab.kermit.Logger
import com.fleeksoft.ksoup.Ksoup
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import me.matsumo.klms.core.datastore.LmsCookieDataStore
import me.matsumo.klms.core.datastore.LmsLoginDataStore
import me.matsumo.klms.core.extensions.suspendRunCatching
import me.matsumo.klms.core.model.LoginData
import me.matsumo.klms.core.repository.api.ApiClient
import me.matsumo.klms.core.repository.api.SyllabusApi
import me.matsumo.klms.core.repository.api.UserApi

interface LmsAuthRepository {

    val loginData: Flow<LoginData>
    val isLoggedIn: SharedFlow<Boolean>

    suspend fun login()
    suspend fun logout()
    suspend fun checkLogin()

    suspend fun setLoginParams(
        email: String,
        password: String,
        token: String,
    )
}

class LmsAuthRepositoryImpl(
    private val client: ApiClient,
    private val loginDataStore: LmsLoginDataStore,
    private val cookieDataStore: LmsCookieDataStore,
    private val ioDispatcher: CoroutineDispatcher,
) : LmsAuthRepository {

    private val scope = CoroutineScope(SupervisorJob() + ioDispatcher)
    private val _isLoggedIn = MutableSharedFlow<Boolean>(replay = 1)

    override val loginData: Flow<LoginData> = loginDataStore.loginData
    override val isLoggedIn: SharedFlow<Boolean> = _isLoggedIn.asSharedFlow()

    override suspend fun login() {
        cookieDataStore.clear()

        val loginData = loginDataStore.loginData.first()
        val csrfToken = getCsrfToken()

        val (mUrl, mParams) = getMicrosoftLoginUrl(csrfToken)
        val (kUrl, kParams) = getKeioLoginUrl(mUrl, mParams)

        val loginCsrfToken = getLoginCsrfToken(kUrl, kParams)

        val (kLoginUrl, kLoginParams) = keioLogin(loginData.email, loginData.password, loginCsrfToken)
        val (mLoginUrl, mLoginParams) = microsoftLogin(kLoginUrl, kLoginParams)
        val (loginUrl, loginParams) = validateLogin(mLoginUrl, mLoginParams)

        login(loginUrl, loginParams)
        syllabusLogin()

        checkLogin()
    }

    override suspend fun logout() {
        cookieDataStore.clear()
    }

    override suspend fun setLoginParams(email: String, password: String, token: String) {
        loginDataStore.setEmail(email)
        loginDataStore.setPassword(password)
        loginDataStore.setToken(token)
    }

    override suspend fun checkLogin() {
        runCatching {
            suspendRunCatching { UserApi(client).getSelfProfile() }.onFailure {
                login()
            }

            suspendRunCatching { SyllabusApi(client).getSyllabus() }.onFailure {
                syllabusLogin()
            }
        }.also {
            _isLoggedIn.emit(it.isSuccess)
        }
    }

    private suspend fun getCsrfToken(): String {
        return client.get("$WEB/login/saml").getCsrfToken()
    }

    private suspend fun getMicrosoftLoginUrl(csrfToken: String): Pair<String, List<Pair<String, String>>> {
        val response = client.form(
            url = "$AUTH/Redirect/SSO",
            params = listOf("execution" to "e1s1"),
            formParams = createShibIdpSession(csrfToken),
        )

        return client.get(response.headers["Location"]!!).getRedirectForm()
    }

    private suspend fun getKeioLoginUrl(loginUrl: String, loginParams: List<Pair<String, String>>): Pair<String, List<Pair<String, String>>> {
        return client.form(
            url = loginUrl,
            formParams = loginParams,
        ).getRedirectForm()
    }

    private suspend fun getLoginCsrfToken(loginUrl: String, loginParams: List<Pair<String, String>>): String {
        val response = client.form(
            url = loginUrl,
            formParams = loginParams,
        )

        return client.get(response.headers["Location"]!!).getCsrfToken()
    }

    private suspend fun keioLogin(email: String, password: String, csrfToken: String): Pair<String, List<Pair<String, String>>> {
        return client.form(
            url = "$AUTH/POST/SSO",
            params = listOf("execution" to "e2s1"),
            formParams = listOf(
                "csrf_token" to csrfToken,
                "j_username" to email,
                "j_password" to password,
                "_eventId_proceed" to "",
            ),
        ).getRedirectForm()
    }

    private suspend fun microsoftLogin(loginUrl: String, loginParams: List<Pair<String, String>>): Pair<String, List<Pair<String, String>>> {
        return client.form(
            url = loginUrl,
            formParams = loginParams,
        ).getRedirectForm()
    }

    private suspend fun validateLogin(loginUrl: String, loginParams: List<Pair<String, String>>): Pair<String, List<Pair<String, String>>> {
        val response = client.form(
            url = loginUrl,
            formParams = loginParams,
        )

        return client.get(response.headers["Location"]!!).getRedirectForm()
    }

    private suspend fun login(loginUrl: String, loginParams: List<Pair<String, String>>) {
        client.form(
            url = loginUrl,
            formParams = loginParams,
        )

        suspendRunCatching {
            require(cookieDataStore.getCookiesMap().containsKey("_normandy_session"))
        }
            .onSuccess { Logger.d("Successfully logged in") }
            .onFailure { Logger.e("Failed to login") }
    }

    private suspend fun syllabusLogin(loginUrl: String, loginParams: List<Pair<String, String>>) {
        val response = client.form(
            url = loginUrl,
            formParams = loginParams,
        )

        client.get(response.headers["Location"]!!)

        suspendRunCatching {
            require(cookieDataStore.getCookiesMap().filterKeys { it.startsWith("_shibsession") }.isNotEmpty())
        }
            .onSuccess { Logger.d("Successfully logged in to syllabus") }
            .onFailure { Logger.e("Failed to login to syllabus") }
    }

    private suspend fun syllabusLogin() {
        val (loginUrl, loginParams) = client.get("https://gslbs.keio.jp/syllabus/login").getRedirectForm()
        val (mUrl, mParams) = microsoftLogin(loginUrl, loginParams)
        val (kUrl, kParams) = validateLogin(mUrl, mParams)

        syllabusLogin(kUrl, kParams)
    }

    private fun createShibIdpSession(csrfToken: String): List<Pair<String, String>> {
        return listOf(
            "csrf_token" to csrfToken,
            "shib_idp_ls_exception.shib_idp_session_ss" to "",
            "shib_idp_ls_success.shib_idp_session_ss" to "true",
            "shib_idp_ls_value.shib_idp_session_ss" to "",
            "shib_idp_ls_exception.shib_idp_persistent_ss" to "",
            "shib_idp_ls_success.shib_idp_persistent_ss" to "true",
            "shib_idp_ls_value.shib_idp_persistent_ss" to "",
            "shib_idp_ls_supported" to "true",
            "_eventId_proceed" to "",
        )
    }

    private suspend fun HttpResponse.getCsrfToken(): String {
        val document = Ksoup.parse(bodyAsText())
        return document.select("input[name=csrf_token]").attr("value")
    }

    private suspend fun HttpResponse.getRedirectForm(): Pair<String, List<Pair<String, String>>> {
        val document = Ksoup.parse(bodyAsText())
        val url = document.select("form").attr("action")
        val params = document.select("form input")
            .associate { it.attr("name") to it.attr("value") }
            .filterKeys { it.isNotBlank() }

        require(url.isNotBlank()) { "Redirect form url is blank" }

        return url to params.toList()
    }

    companion object {
        private const val WEB = "https://lms.keio.jp"
        private const val AUTH = "https://auth.keio.jp/idp/profile/SAML2"
    }
}
