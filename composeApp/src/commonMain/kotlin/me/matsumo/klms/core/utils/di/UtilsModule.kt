package me.matsumo.klms.core.utils.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import me.matsumo.klms.core.utils.IOScope
import me.matsumo.klms.core.utils.MainScope
import org.koin.dsl.module

val utilsModule = module {
    single<CoroutineDispatcher> {
        Dispatchers.IO
    }

    single<MainScope> {
        MainScope()
    }

    single<IOScope> {
        IOScope()
    }
}
