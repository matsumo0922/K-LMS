package me.matsumo.klms.core.ui.di

import me.matsumo.klms.core.ui.extension.NavigatorExtension
import me.matsumo.klms.core.ui.extension.NavigatorExtensionImpl
import me.matsumo.klms.core.ui.extension.SnackbarExtension
import me.matsumo.klms.core.ui.extension.SnackbarExtensionImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual val uiSubModule: Module = module {
    single<NavigatorExtension> {
        NavigatorExtensionImpl(
            context = get(),
        )
    }

    single<SnackbarExtension> {
        SnackbarExtensionImpl(
            context = get(),
        )
    }
}
