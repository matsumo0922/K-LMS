package me.matsumo.klms.screen.library.calendar

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val LibraryCalendarRoute = "libraryCalendar"

fun NavController.navigateToLibraryCalendar(navOptions: NavOptions? = null) {
    this.navigate(LibraryCalendarRoute, navOptions)
}

fun NavGraphBuilder.libraryCalendarScreen() {
    composable(LibraryCalendarRoute) {

    }
}
