package caios.android.klms.feature.library.course

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import caios.android.klms.core.ui.animation.NavigateAnimation

const val LibraryCourseRoute = "libraryCourse"

fun NavController.navigateToLibraryCourse(navOptions: NavOptions? = null) {
    this.navigate(LibraryCourseRoute, navOptions)
}

fun NavGraphBuilder.libraryCourseScreen(
    openDrawer: () -> Unit,
) {
    composable(
        route = LibraryCourseRoute,
        enterTransition = { NavigateAnimation.Library.enter },
        exitTransition = { NavigateAnimation.Library.exit },
    ) {
        LibraryCourseScreen(
            modifier = Modifier.fillMaxSize(),
            openDrawer = openDrawer,
        )
    }
}
