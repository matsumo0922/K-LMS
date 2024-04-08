package me.matsumo.klms.core.datastore

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import me.matsumo.klms.core.model.LoginData

class LmsLoginDataStore(
    private val preferenceHelper: PreferenceHelper,
    private val formatter: Json,
    private val ioDispatcher: CoroutineDispatcher,
) {
    private val loginPreference = preferenceHelper.create(PreferencesName.LMS_LOGIN)

    val loginData = loginPreference.data.map {
        it.deserialize(formatter, LoginData.serializer(), LoginData.default())
    }

    suspend fun clear() {
        LoginData.default().also { data ->
            setEmail(data.email)
            setPassword(data.password)
            setToken(data.token)
        }
    }

    suspend fun setEmail(email: String) = withContext(ioDispatcher) {
        loginPreference.edit {
            it[stringPreferencesKey(LoginData::email.name)] = email
        }
    }

    suspend fun setPassword(password: String) = withContext(ioDispatcher) {
        loginPreference.edit {
            it[stringPreferencesKey(LoginData::password.name)] = password
        }
    }

    suspend fun setToken(token: String) = withContext(ioDispatcher) {
        loginPreference.edit {
            it[stringPreferencesKey(LoginData::token.name)] = token
        }
    }
}
