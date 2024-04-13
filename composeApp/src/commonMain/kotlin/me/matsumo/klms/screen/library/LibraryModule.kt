package me.matsumo.klms.screen.library

import org.koin.dsl.module

val libraryModule = module {

    factory {
        LibraryViewModel(
            userDataRepository = get(),
            lmsRepository = get(),
        )
    }
}
