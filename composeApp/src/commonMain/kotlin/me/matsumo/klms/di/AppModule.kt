package me.matsumo.klms.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import me.matsumo.klms.core.model.LmsConfig
import org.koin.dsl.module

expect fun getLmsConfig(): LmsConfig

val appModule = module {

    single {
        getLmsConfig()
    }

    single<CoroutineDispatcher> {
        Dispatchers.IO
    }
}
