package me.matsumo.klms.screen.library.message

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val LibraryMessageRoute = "libraryMessage"

fun NavController.navigateToLibraryMessage(navOptions: NavOptions? = null) {
    this.navigate(LibraryMessageRoute, navOptions)
}

fun NavGraphBuilder.libraryMessageScreen() {
    composable(LibraryMessageRoute) {

    }
}
