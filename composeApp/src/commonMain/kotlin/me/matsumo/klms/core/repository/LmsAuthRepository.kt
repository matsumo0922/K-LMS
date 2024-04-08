package me.matsumo.klms.core.repository

import com.fleeksoft.ksoup.Ksoup
import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import me.matsumo.klms.core.datastore.LmsCookieDataStore
import me.matsumo.klms.core.datastore.LmsLoginDataStore
import me.matsumo.klms.core.model.LoginData
import me.matsumo.klms.core.utils.suspendRunCatching

interface LmsAuthRepository {

    val loginData: Flow<LoginData>

    fun login()
    fun logout()

    fun setLoginParams(
        email: String,
        password: String,
        token: String,
    )
}

class LmsAuthRepositoryImpl(
    private val client: HttpClient,
    private val loginDataStore: LmsLoginDataStore,
    private val cookieDataStore: LmsCookieDataStore,
    private val ioDispatcher: CoroutineDispatcher,
) : LmsAuthRepository, NetworkRepository(client) {

    private val scope = CoroutineScope(SupervisorJob() + ioDispatcher)

    override val loginData: Flow<LoginData> = loginDataStore.loginData

    override fun login() {
        scope.launch {
            suspendRunCatching {
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
            }
        }
    }

    override fun logout() {
        scope.launch {
            cookieDataStore.clear()
        }
    }

    override fun setLoginParams(email: String, password: String, token: String) {
        scope.launch {
            loginDataStore.setEmail(email)
            loginDataStore.setPassword(password)
            loginDataStore.setToken(token)
        }
    }

    private suspend fun getCsrfToken(): String {
        return get("$WEB/login/saml").getCsrfToken()
    }

    private suspend fun getMicrosoftLoginUrl(csrfToken: String): Pair<String, Map<String, String>> {
        val response = form(
            url = "$AUTH/Redirect/SSO",
            params = mapOf("execution" to "e1s1"),
            formParams = createShibIdpSession(csrfToken),
        )

        return get(response.headers["Location"]!!).getRedirectForm()
    }

    private suspend fun getKeioLoginUrl(loginUrl: String, loginParams: Map<String, String>): Pair<String, Map<String, String>> {
        return form(
            url = loginUrl,
            formParams = loginParams,
        ).getRedirectForm()
    }

    private suspend fun getLoginCsrfToken(loginUrl: String, loginParams: Map<String, String>): String {
        val response = form(
            url = loginUrl,
            formParams = loginParams,
        )

        return get(response.headers["Location"]!!).getCsrfToken()
    }

    private suspend fun keioLogin(email: String, password: String, csrfToken: String): Pair<String, Map<String, String>>{
        return form(
            url = "$AUTH/POST/SSO",
            params = mapOf("execution" to "e2s1"),
            formParams = mapOf(
                "csrf_token" to csrfToken,
                "j_username" to email,
                "j_password" to password,
                "_eventId_proceed" to "",
            ),
        ).getRedirectForm()
    }

    private suspend fun microsoftLogin(loginUrl: String, loginParams: Map<String, String>): Pair<String, Map<String, String>>{
        return form(
            url = loginUrl,
            formParams = loginParams,
        ).getRedirectForm()
    }

    private suspend fun validateLogin(loginUrl: String, loginParams: Map<String, String>): Pair<String, Map<String, String>> {
        val response = form(
            url = loginUrl,
            formParams = loginParams,
        )

        return get(response.headers["Location"]!!).getRedirectForm()
    }

    private suspend fun login(loginUrl: String, loginParams: Map<String, String>) {
        form(
            url = loginUrl,
            formParams = loginParams,
        )

        require(cookieDataStore.getCookiesMap().containsKey("_normandy_session")) { "Login failed" }
    }

    private fun createShibIdpSession(csrfToken: String): Map<String, String> {
        return mapOf(
            "csrf_token" to csrfToken,
            "shib_idp_ls_exception.shib_idp_session_ss" to "",
            "shib_idp_ls_success.shib_idp_session_ss" to "true",
            "shib_idp_ls_value.shib_idp_session_ss" to "",
            "shib_idp_ls_exception.shib_idp_persistent_ss" to "",
            "shib_idp_ls_success.shib_idp_persistent_ss" to "true",
            "shib_idp_ls_value.shib_idp_persistent_ss" to "",
            "shib_idp_ls_supported" to "true",
            "_eventId_proceed" to ""
        )
    }

    private suspend fun HttpResponse.getCsrfToken(): String {
        val document = Ksoup.parse(bodyAsText())
        return document.select("input[name=csrf_token]").attr("value")
    }

    private suspend fun HttpResponse.getRedirectForm(): Pair<String, Map<String, String>> {
        val document = Ksoup.parse(bodyAsText())
        val url = document.select("form").attr("action")
        val params = document.select("form input")
            .associate { it.attr("name") to it.attr("value") }
            .filterKeys { it.isNotBlank() }

        require(url.isNotBlank()) { "Redirect form url is blank" }

        return url to params
    }

    companion object {
        private const val WEB = "https://lms.keio.jp"
        private const val AUTH = "https://auth.keio.jp/idp/profile/SAML2"
    }
}
