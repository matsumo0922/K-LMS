package me.matsumo.klms.screen.library

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val LibraryRoute = "library"

fun NavController.navigateToLibrary() {
    this.navigate(LibraryRoute)
}

fun NavGraphBuilder.libraryScreen() {
    composable(LibraryRoute) {
        LibraryRoute()
    }
}
