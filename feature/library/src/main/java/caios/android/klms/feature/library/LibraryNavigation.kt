package caios.android.klms.feature.library

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import caios.android.klms.core.ui.animation.NavigateAnimation

const val LibraryRoute = "library"

fun NavController.navigateToLibrary() {
    this.navigate(LibraryRoute)
}

fun NavGraphBuilder.libraryScreen(
    navigateToSettingTop: () -> Unit,
    navigateToAbout: () -> Unit,
    navigateToBillingPlus: () -> Unit,
) {
    composable(
        route = LibraryRoute,
        enterTransition = {
            when (initialState.destination.route) {
                in LibraryRoutes -> NavigateAnimation.Library.enter
                else -> NavigateAnimation.Horizontal.enter
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                in LibraryRoutes -> NavigateAnimation.Library.exit
                else -> NavigateAnimation.Horizontal.exit
            }
        },
        popEnterTransition = {
            when (initialState.destination.route) {
                in LibraryRoutes -> NavigateAnimation.Library.enter
                else -> NavigateAnimation.Horizontal.popEnter
            }
        },
        popExitTransition = {
            when (targetState.destination.route) {
                in LibraryRoutes -> NavigateAnimation.Library.exit
                else -> NavigateAnimation.Horizontal.popExit
            }
        },
    ) {
        LibraryScreen(
            modifier = Modifier.fillMaxSize(),
            navigateToSettingTop = navigateToSettingTop,
            navigateToAbout = navigateToAbout,
            navigateToBillingPlus = navigateToBillingPlus,
        )
    }
}
