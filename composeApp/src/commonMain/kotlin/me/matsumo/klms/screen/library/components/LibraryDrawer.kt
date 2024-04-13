package me.matsumo.klms.screen.library.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.DrawerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import me.matsumo.klms.core.model.lms.LmsAccount

@Composable
fun LibraryDrawer(
    state: DrawerState,
    account: LmsAccount?,
    currentDestination: NavDestination?,
    navigateToLibraryScreen: (LibraryDestination) -> Unit,
    navigateToSetting: () -> Unit,
    navigateToAbout: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ModalDrawerSheet(
        drawerContainerColor = MaterialTheme.colorScheme.surface,
        windowInsets = WindowInsets(0, 0, 0, 0),
    ) {
        LibraryDrawerContent(
            modifier = modifier,
            state = state,
            account = account,
            currentDestination = currentDestination,
            navigateToLibraryScreen = navigateToLibraryScreen,
            navigateToSetting = navigateToSetting,
            navigateToAbout = navigateToAbout,
        )
    }
}
