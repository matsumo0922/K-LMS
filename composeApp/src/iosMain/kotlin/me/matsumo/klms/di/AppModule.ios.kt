package me.matsumo.klms.di

import me.matsumo.fanbox.BuildKonfig
import me.matsumo.klms.core.model.LmsConfig

actual fun getLmsConfig(): LmsConfig = LmsConfig(
    versionCode = BuildKonfig.VERSION_CODE,
    versionName = BuildKonfig.VERSION_NAME,
    developerPassword = BuildKonfig.DEVELOPER_PASSWORD,
)
