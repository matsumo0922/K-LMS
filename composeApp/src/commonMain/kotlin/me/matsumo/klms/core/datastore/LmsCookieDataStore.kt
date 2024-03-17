package me.matsumo.klms.core.datastore

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class LmsCookieDataStore(
    private val preferenceHelper: PreferenceHelper,
) {
    private val cookiePreference = preferenceHelper.create(PreferencesName.KLMS_COOKIE)

    val data: Flow<String> = cookiePreference.data.map { it[stringPreferencesKey(KEY_COOKIE)] ?: "" }

    suspend fun save(cookie: String) {
        cookiePreference.edit {
            it[stringPreferencesKey(KEY_COOKIE)] = cookie
        }
    }

    suspend fun get(): String? {
        return cookiePreference.data.firstOrNull()?.get(stringPreferencesKey(KEY_COOKIE))
    }

    suspend fun addCookies(cookies: List<String>) {
        val resultCookiesMap = getCookies().toCookiesMap().toMutableMap()
        val newCookiesMap = cookies.toCookiesMap()

        for ((key, value) in newCookiesMap) {
            resultCookiesMap[key] = value.trim()
        }

        save(resultCookiesMap.map { "${it.key}=${it.value}" }.joinToString(";"))
    }

    suspend fun getCookies(): List<String> {
        return (get()?.split(";")?.filter { it.isNotBlank() } ?: emptyList()).also {
            Logger.d("CookieDataStore getCookies: ${it.joinToString(";")}")
        }
    }

    private fun List<String>.toCookiesMap(): Map<String, String> {
        return mapNotNull {
            it.split("=", limit = 2)
                .let { item -> if (item.size == 2) item else null }
                ?.let { item -> item[0] to item[1] }
        }.toMap()
    }

    companion object {
        private const val KEY_COOKIE = "cookie"
    }
}
