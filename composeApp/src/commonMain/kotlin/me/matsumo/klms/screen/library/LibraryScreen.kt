package me.matsumo.klms.screen.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import me.matsumo.klms.core.extensions.koinViewModel
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.model.lms.LmsProfile
import me.matsumo.klms.core.model.lms.LmsUser
import me.matsumo.klms.core.ui.AsyncLoadContents
import me.matsumo.klms.screen.library.calendar.navigateToLibraryCalendar
import me.matsumo.klms.screen.library.components.LibraryBottomBar
import me.matsumo.klms.screen.library.components.LibraryDestination
import me.matsumo.klms.screen.library.components.LibraryDrawer
import me.matsumo.klms.screen.library.home.navigateToLibraryHome
import me.matsumo.klms.screen.library.message.navigateToLibraryMessage
import me.matsumo.klms.screen.library.timetable.navigateToLibraryTimetable

@Composable
fun LibraryRoute(
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel = koinViewModel(LibraryViewModel::class),
) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        if (screenState !is ScreenState.Idle) {
            viewModel.fetch()
        }
    }

    AsyncLoadContents(
        modifier = modifier,
        screenState = screenState,
    ) {
        LibraryScreen(
            modifier = Modifier.fillMaxSize(),
            userData = it.userData,
            profile = it.profile,
            user = it.user,
        )
    }
}

@Composable
private fun LibraryScreen(
    userData: UserData,
    profile: LmsProfile?,
    user: LmsUser?,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()

    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            LibraryDrawer(
                modifier = Modifier.fillMaxHeight(),
                state = drawerState,
                account = null,
                currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                navigateToLibraryScreen = navController::navigateToLibraryDestination,
                navigateToSetting = {},
                navigateToAbout = {},
            )
        }
    ) {
        Column {
            LibraryNavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                openDrawer = {
                    scope.launch {
                        drawerState.open()
                    }
                }
            )

            LibraryBottomBar(
                modifier = Modifier.fillMaxWidth(),
                destinations = LibraryDestination.entries.toImmutableList(),
                currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                navigateToDestination = navController::navigateToLibraryDestination,
            )
        }
    }
}

fun NavHostController.navigateToLibraryDestination(destination: LibraryDestination) {
    val navOption = navOptions {
        popUpTo(graph.findStartDestination().route.orEmpty()) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (destination) {
        LibraryDestination.Home -> navigateToLibraryHome(navOption)
        LibraryDestination.Calendar -> navigateToLibraryCalendar(navOption)
        LibraryDestination.Message -> navigateToLibraryMessage(navOption)
        LibraryDestination.Timetable -> navigateToLibraryTimetable(navOption)
    }
}
