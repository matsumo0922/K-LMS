package caios.android.klms.core.common

data class KlmsConfig(
    val applicationId: String,
    val buildType: String,
    val versionCode: String,
    val versionName: String,
    val isDebug: Boolean,
    val developerPassword: String,
) {
    companion object {
        fun dummy(): KlmsConfig {
            return KlmsConfig(
                applicationId = "caios.android.klms",
                buildType = "release",
                versionCode = "223",
                versionName = "1.4.21",
                isDebug = false,
                developerPassword = "1919191919",
            )
        }
    }
}
