package caios.android.klms.feature.library

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import caios.android.fanbox.feature.library.LibraryViewModel
import caios.android.klms.core.ui.AsyncLoadContents
import caios.android.klms.feature.library.component.LibraryBottomBar
import caios.android.klms.feature.library.component.LibraryDestination
import caios.android.klms.feature.library.component.LibraryDrawer
import caios.android.klms.feature.library.course.navigateToLibraryCourse
import caios.android.klms.feature.library.home.navigateToLibraryHome
import caios.android.klms.feature.library.mail.navigateToLibraryMail
import caios.android.klms.feature.library.timetable.navigateToLibraryTimeTable
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch

@Composable
fun LibraryScreen(
    navigateToSettingTop: () -> Unit,
    navigateToAbout: () -> Unit,
    navigateToBillingPlus: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    AsyncLoadContents(
        modifier = modifier,
        screenState = screenState,
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                LibraryDrawer(
                    state = drawerState,
                    userData = it.userData,
                    currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                    onClickLibrary = navController::navigateToLibrary,
                    navigateToSetting = { },
                    navigateToAbout = navigateToAbout,
                    navigateToBillingPlus = navigateToBillingPlus,
                )
            },
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    LibraryBottomBar(
                        destinations = LibraryDestination.entries.toImmutableList(),
                        currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                        navigateToDestination = navController::navigateToLibrary,
                    )
                },
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
            ) {
                LibraryNavHost(
                    modifier = Modifier.padding(it),
                    navController = navController,
                    openDrawer = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                )
            }
        }
    }
}

private fun NavHostController.navigateToLibrary(destination: LibraryDestination) {
    val navOption = navOptions {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    when (destination) {
        LibraryDestination.Home -> navigateToLibraryHome(navOption)
        LibraryDestination.Course -> navigateToLibraryCourse(navOption)
        LibraryDestination.Mail -> navigateToLibraryMail(navOption)
        LibraryDestination.TimeTable -> navigateToLibraryTimeTable(navOption)
    }
}
