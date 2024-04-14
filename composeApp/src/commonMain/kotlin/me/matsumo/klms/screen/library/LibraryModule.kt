package me.matsumo.klms.screen.library

import me.matsumo.klms.screen.library.home.LibraryHomeViewModel
import org.koin.dsl.module

val libraryModule = module {

    factory {
        LibraryViewModel(
            userDataRepository = get(),
            lmsRepository = get(),
        )
    }

    factory {
        LibraryHomeViewModel(
            userDataRepository = get(),
            lmsRepository = get(),
        )
    }
}
