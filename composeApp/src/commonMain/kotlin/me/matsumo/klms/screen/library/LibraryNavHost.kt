package me.matsumo.klms.screen.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.matsumo.klms.screen.library.calendar.libraryCalendarScreen
import me.matsumo.klms.screen.library.home.LibraryHomeRoute
import me.matsumo.klms.screen.library.home.libraryHomeScreen
import me.matsumo.klms.screen.library.message.libraryMessageScreen
import me.matsumo.klms.screen.library.timetable.libraryTimetableScreen

@Composable
fun LibraryNavHost(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = LibraryHomeRoute,
    ) {
        libraryHomeScreen(
            openDrawer = openDrawer,
        )

        libraryCalendarScreen()
        libraryMessageScreen()
        libraryTimetableScreen()
    }
}
