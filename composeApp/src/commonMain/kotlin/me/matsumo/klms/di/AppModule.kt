package me.matsumo.klms.di

import me.matsumo.fanbox.BuildKonfig
import me.matsumo.klms.core.model.LmsConfig
import org.koin.dsl.module

val appModule = module {

    single {
        LmsConfig(
            versionCode = BuildKonfig.VERSION_CODE,
            versionName = BuildKonfig.VERSION_NAME,
            developerPassword = BuildKonfig.DEVELOPER_PASSWORD,
        )
    }
}
