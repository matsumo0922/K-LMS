package me.matsumo.klms.core.model

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val lmsId: String,
    val themeConfig: ThemeConfig,
    val themeColorConfig: ThemeColorConfig,
    val isAgreedPrivacyPolicy: Boolean,
    val isAgreedTermsOfService: Boolean,
    val isUseDynamicColor: Boolean,
    val isDeveloperMode: Boolean,
    val isPlusMode: Boolean,
) {
    val hasPrivilege get() = isPlusMode || isDeveloperMode

    companion object {
        fun default(): UserData {
            return UserData(
                lmsId = "",
                themeConfig = ThemeConfig.System,
                themeColorConfig = ThemeColorConfig.Blue,
                isAgreedPrivacyPolicy = false,
                isAgreedTermsOfService = false,
                isUseDynamicColor = false,
                isDeveloperMode = false,
                isPlusMode = false,
            )
        }
    }
}
