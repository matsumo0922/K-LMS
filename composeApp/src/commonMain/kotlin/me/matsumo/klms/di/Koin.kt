package me.matsumo.klms.di

import me.matsumo.klms.core.datastore.di.dataStoreHelperModule
import me.matsumo.klms.core.datastore.di.dataStoreModule
import me.matsumo.klms.core.repository.di.repositoryModule
import me.matsumo.klms.core.ui.di.uiSubModule
import me.matsumo.klms.core.utils.di.utilsModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun KoinApplication.applyModules() {
    modules(repositoryModule)
    modules(dataStoreModule)
    modules(dataStoreHelperModule)
    modules(uiSubModule)
    modules(utilsModule)
}
