package me.matsumo.klms.core.extensions.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module
import org.koin.dsl.module

val ExtensionsModule = module {
    single<CoroutineDispatcher> {
        Dispatchers.IO
    }
}
