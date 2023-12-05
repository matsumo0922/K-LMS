package caios.android.klms.core.repository

import caios.android.klms.core.datastore.KlmsPreferencesDataStore
import caios.android.klms.core.model.ThemeColorConfig
import caios.android.klms.core.model.ThemeConfig
import caios.android.klms.core.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun setKlmsId(id: String)
    suspend fun setAgreedPrivacyPolicy(isAgreed: Boolean)
    suspend fun setAgreedTermsOfService(isAgreed: Boolean)
    suspend fun setThemeConfig(themeConfig: ThemeConfig)
    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig)
    suspend fun setTestUser(isTestUser: Boolean)
    suspend fun setDeveloperMode(isDeveloperMode: Boolean)
    suspend fun setPlusMode(isPlusMode: Boolean)
    suspend fun setUseDynamicColor(useDynamicColor: Boolean)
}

class UserDataRepositoryImpl @Inject constructor(
    private val klmsPreferencesDataStore: KlmsPreferencesDataStore,
) : UserDataRepository {

    override val userData: Flow<UserData> = klmsPreferencesDataStore.userData

    override suspend fun setKlmsId(id: String) {
        klmsPreferencesDataStore.setKlmsId(id)
    }

    override suspend fun setAgreedPrivacyPolicy(isAgreed: Boolean) {
        klmsPreferencesDataStore.setAgreedPrivacyPolicy(isAgreed)
    }

    override suspend fun setAgreedTermsOfService(isAgreed: Boolean) {
        klmsPreferencesDataStore.setAgreedTermsOfService(isAgreed)
    }

    override suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        klmsPreferencesDataStore.setThemeConfig(themeConfig)
    }

    override suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        klmsPreferencesDataStore.setThemeColorConfig(themeColorConfig)
    }

    override suspend fun setTestUser(isTestUser: Boolean) {
        klmsPreferencesDataStore.setTestUser(isTestUser)
    }

    override suspend fun setDeveloperMode(isDeveloperMode: Boolean) {
        klmsPreferencesDataStore.setDeveloperMode(isDeveloperMode)
    }

    override suspend fun setPlusMode(isPlusMode: Boolean) {
        klmsPreferencesDataStore.setPlusMode(isPlusMode)
    }

    override suspend fun setUseDynamicColor(useDynamicColor: Boolean) {
        klmsPreferencesDataStore.setUseDynamicColor(useDynamicColor)
    }
}
