package me.matsumo.klms.core.model

data class LmsConfig(
    val versionCode: String,
    val versionName: String,
    val developerPassword: String,
) {
    companion object {
        fun dummy(): LmsConfig {
            return LmsConfig(
                versionCode = "223",
                versionName = "1.4.21",
                developerPassword = "1919191919",
            )
        }
    }
}
