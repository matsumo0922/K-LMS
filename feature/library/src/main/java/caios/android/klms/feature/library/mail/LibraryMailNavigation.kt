package caios.android.klms.feature.library.mail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import caios.android.klms.core.ui.animation.NavigateAnimation

const val LibraryMailRoute = "libraryMail"

fun NavController.navigateToLibraryMail(navOptions: NavOptions? = null) {
    this.navigate(LibraryMailRoute, navOptions)
}

fun NavGraphBuilder.libraryMailScreen(
    openDrawer: () -> Unit,
) {
    composable(
        route = LibraryMailRoute,
        enterTransition = { NavigateAnimation.Library.enter },
        exitTransition = { NavigateAnimation.Library.exit },
    ) {
        LibraryMailScreen(
            modifier = Modifier.fillMaxSize(),
            openDrawer = openDrawer,
        )
    }
}
