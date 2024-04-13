package me.matsumo.klms.di

import me.matsumo.klms.core.datastore.di.dataStoreHelperModule
import me.matsumo.klms.core.datastore.di.dataStoreModule
import me.matsumo.klms.core.extensions.di.ExtensionsModule
import me.matsumo.klms.core.repository.di.repositoryModule
import me.matsumo.klms.core.ui.di.uiSubModule
import me.matsumo.klms.screen.library.libraryModule
import me.matsumo.klms.screen.welcome.welcomeModule
import org.koin.core.KoinApplication

fun KoinApplication.applyModules() {
    modules(appModule)

    modules(repositoryModule)
    modules(dataStoreModule)
    modules(dataStoreHelperModule)
    modules(uiSubModule)
    modules(ExtensionsModule)

    modules(libraryModule)
    modules(welcomeModule)
}
