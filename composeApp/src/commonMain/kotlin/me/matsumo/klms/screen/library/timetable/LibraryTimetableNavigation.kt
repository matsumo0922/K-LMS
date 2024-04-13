package me.matsumo.klms.screen.library.timetable

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val LibraryTimetableRoute = "libraryTimetable"

fun NavController.navigateToLibraryTimetable(navOptions: NavOptions? = null) {
    this.navigate(LibraryTimetableRoute, navOptions)
}

fun NavGraphBuilder.libraryTimetableScreen() {
    composable(LibraryTimetableRoute) {

    }
}
