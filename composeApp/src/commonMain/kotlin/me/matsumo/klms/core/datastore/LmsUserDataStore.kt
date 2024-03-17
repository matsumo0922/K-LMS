package me.matsumo.klms.core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import me.matsumo.klms.core.model.ThemeColorConfig
import me.matsumo.klms.core.model.ThemeConfig
import me.matsumo.klms.core.model.UserData

class LmsUserDataStore(
    private val preferenceHelper: PreferenceHelper,
    private val formatter: Json,
    private val ioDispatcher: CoroutineDispatcher,
) {
    private val userPreference = preferenceHelper.create(PreferencesName.APP_SETTINGS)

    val userData = userPreference.data.map {
        it.deserialize(formatter, UserData.serializer(), UserData.default())
    }

    suspend fun setDefault() = withContext(ioDispatcher) {
        UserData.default().also { data ->
            setLmsId(data.lmsId)
            setAgreedPrivacyPolicy(data.isAgreedPrivacyPolicy)
            setAgreedTermsOfService(data.isAgreedTermsOfService)
            setThemeConfig(data.themeConfig)
            setThemeColorConfig(data.themeColorConfig)
            setUseDynamicColor(data.isUseDynamicColor)
            setDeveloperMode(data.isDeveloperMode)
            setPlusMode(data.isPlusMode)
        }
    }

    suspend fun setLmsId(id: String) = withContext(ioDispatcher) {
        userPreference.edit {
            it[stringPreferencesKey(UserData::lmsId.name)] = id
        }
    }

    suspend fun setAgreedPrivacyPolicy(isAgreed: Boolean) = withContext(ioDispatcher) {
        userPreference.edit {
            it[booleanPreferencesKey(UserData::isAgreedPrivacyPolicy.name)] = isAgreed
        }
    }

    suspend fun setAgreedTermsOfService(isAgreed: Boolean) = withContext(ioDispatcher) {
        userPreference.edit {
            it[booleanPreferencesKey(UserData::isAgreedTermsOfService.name)] = isAgreed
        }
    }

    suspend fun setThemeConfig(themeConfig: ThemeConfig) = withContext(ioDispatcher) {
        userPreference.edit {
            it[stringPreferencesKey(UserData::themeConfig.name)] = themeConfig.name
        }
    }

    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) = withContext(ioDispatcher) {
        userPreference.edit {
            it[stringPreferencesKey(UserData::themeColorConfig.name)] = themeColorConfig.name
        }
    }

    suspend fun setUseDynamicColor(useDynamicColor: Boolean) = withContext(ioDispatcher) {
        userPreference.edit {
            it[booleanPreferencesKey(UserData::isUseDynamicColor.name)] = useDynamicColor
        }
    }

    suspend fun setDeveloperMode(isDeveloperMode: Boolean) = withContext(ioDispatcher) {
        userPreference.edit {
            it[booleanPreferencesKey(UserData::isDeveloperMode.name)] = isDeveloperMode
        }
    }

    suspend fun setPlusMode(isPlusMode: Boolean) = withContext(ioDispatcher) {
        userPreference.edit {
            it[booleanPreferencesKey(UserData::isPlusMode.name)] = isPlusMode
        }
    }
}
