package me.matsumo.klms.core.repository

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.receiveAsFlow
import me.matsumo.klms.core.datastore.LmsUserDataStore
import me.matsumo.klms.core.model.ThemeColorConfig
import me.matsumo.klms.core.model.ThemeConfig
import me.matsumo.klms.core.model.UserData

interface UserDataRepository {

    val userData: Flow<UserData>
    val updatePlusMode: Flow<Boolean>

    suspend fun setDefault()
    suspend fun setLmsId(id: String)
    suspend fun setAgreedPrivacyPolicy(isAgreed: Boolean)
    suspend fun setAgreedTermsOfService(isAgreed: Boolean)
    suspend fun setThemeConfig(themeConfig: ThemeConfig)
    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig)
    suspend fun setUseDynamicColor(useDynamicColor: Boolean)
    suspend fun setDeveloperMode(isDeveloperMode: Boolean)
    suspend fun setPlusMode(isPlusMode: Boolean)
}

class UserDataRepositoryImpl(
    private val lmsDataStore: LmsUserDataStore,
) : UserDataRepository {

    private val _updatePlusMode = Channel<Boolean>(Channel.BUFFERED)

    override val updatePlusMode: Flow<Boolean> = _updatePlusMode.receiveAsFlow()

    override val userData: Flow<UserData> = lmsDataStore.userData

    override suspend fun setDefault() {
        lmsDataStore.setDefault()
    }

    override suspend fun setLmsId(id: String) {
        lmsDataStore.setLmsId(id)
    }

    override suspend fun setAgreedPrivacyPolicy(isAgreed: Boolean) {
        lmsDataStore.setAgreedPrivacyPolicy(isAgreed)
    }

    override suspend fun setAgreedTermsOfService(isAgreed: Boolean) {
        lmsDataStore.setAgreedTermsOfService(isAgreed)
    }

    override suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        lmsDataStore.setThemeConfig(themeConfig)
    }

    override suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        lmsDataStore.setThemeColorConfig(themeColorConfig)
    }

    override suspend fun setDeveloperMode(isDeveloperMode: Boolean) {
        lmsDataStore.setDeveloperMode(isDeveloperMode)
    }

    override suspend fun setUseDynamicColor(useDynamicColor: Boolean) {
        lmsDataStore.setUseDynamicColor(useDynamicColor)
    }

    override suspend fun setPlusMode(isPlusMode: Boolean) {
        if (userData.first().isPlusMode != isPlusMode) {
            lmsDataStore.setPlusMode(isPlusMode)
            _updatePlusMode.send(isPlusMode)

            if (!isPlusMode) {
                setUseDynamicColor(false)
            }
        }
    }
}
