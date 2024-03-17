package me.matsumo.klms.core.utils.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val utilsModule = module {
    single<CoroutineDispatcher> {
        Dispatchers.Default
    }
}
