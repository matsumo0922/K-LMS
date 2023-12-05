package caios.android.klms.feature.library.timetable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import caios.android.klms.core.ui.animation.NavigateAnimation

const val LibraryTimeTableRoute = "libraryTimeTable"

fun NavController.navigateToLibraryTimeTable(navOptions: NavOptions? = null) {
    this.navigate(LibraryTimeTableRoute, navOptions)
}

fun NavGraphBuilder.libraryTimeTableScreen(
    openDrawer: () -> Unit,
) {
    composable(
        route = LibraryTimeTableRoute,
        enterTransition = { NavigateAnimation.Library.enter },
        exitTransition = { NavigateAnimation.Library.exit },
    ) {
        LibraryTimeTableScreen(
            modifier = Modifier.fillMaxSize(),
            openDrawer = openDrawer,
        )
    }
}
