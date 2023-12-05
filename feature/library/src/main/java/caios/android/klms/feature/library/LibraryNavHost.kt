package caios.android.klms.feature.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import caios.android.klms.feature.library.course.LibraryCourseRoute
import caios.android.klms.feature.library.course.libraryCourseScreen
import caios.android.klms.feature.library.home.LibraryHomeRoute
import caios.android.klms.feature.library.home.libraryHomeScreen
import caios.android.klms.feature.library.mail.LibraryMailRoute
import caios.android.klms.feature.library.mail.libraryMailScreen
import caios.android.klms.feature.library.timetable.LibraryTimeTableRoute
import caios.android.klms.feature.library.timetable.libraryTimeTableScreen

@Composable
fun LibraryNavHost(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = LibraryHomeRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        libraryHomeScreen(
            openDrawer = openDrawer,
        )

        libraryCourseScreen(
            openDrawer = openDrawer,
        )

        libraryMailScreen(
            openDrawer = openDrawer,
        )

        libraryTimeTableScreen(
            openDrawer = openDrawer,
        )
    }
}

internal val LibraryRoutes = listOf(
    LibraryHomeRoute,
    LibraryCourseRoute,
    LibraryMailRoute,
    LibraryTimeTableRoute,
)
