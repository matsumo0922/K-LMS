package me.matsumo.klms.core.datastore.di

import me.matsumo.klms.core.datastore.LmsCookieDataStore
import me.matsumo.klms.core.datastore.LmsUserDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

expect val dataStoreHelperModule: Module

val dataStoreModule = module {
    single {
        LmsUserDataStore(
            preferenceHelper = get(),
            formatter = get(),
            ioDispatcher = get(),
        )
    }

    single {
        LmsCookieDataStore(
            preferenceHelper = get(),
        )
    }
}
