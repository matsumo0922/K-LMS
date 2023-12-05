package caios.android.klms.core.model

import androidx.compose.runtime.Stable

@Stable
data class UserData(
    val klmsId: String,
    val themeConfig: ThemeConfig,
    val themeColorConfig: ThemeColorConfig,
    val isAgreedPrivacyPolicy: Boolean,
    val isAgreedTermsOfService: Boolean,
    val isDynamicColor: Boolean,
    val isTestUser: Boolean,
    val isDeveloperMode: Boolean,
    val isPlusMode: Boolean,
) {
    val hasPrivilege get() = isPlusMode || isDeveloperMode

    companion object {
        fun dummy(): UserData {
            return UserData(
                klmsId = "",
                themeConfig = ThemeConfig.System,
                themeColorConfig = ThemeColorConfig.Default,
                isAgreedPrivacyPolicy = false,
                isAgreedTermsOfService = false,
                isDynamicColor = true,
                isTestUser = false,
                isDeveloperMode = true,
                isPlusMode = false,
            )
        }
    }
}
