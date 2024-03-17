package me.matsumo.klms.core.datastore.di

import me.matsumo.klms.core.datastore.PreferenceHelper
import me.matsumo.klms.core.datastore.PreferenceHelperImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual val dataStoreHelperModule: Module = module {

    single<PreferenceHelper> {
        PreferenceHelperImpl(
            context = get(),
            ioDispatcher = get(),
        )
    }
}
