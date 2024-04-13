package me.matsumo.klms.screen.library.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.navigation_about
import k_lms.composeapp.generated.resources.navigation_calendar
import k_lms.composeapp.generated.resources.navigation_home
import k_lms.composeapp.generated.resources.navigation_message
import k_lms.composeapp.generated.resources.navigation_settings
import k_lms.composeapp.generated.resources.navigation_timetable
import kotlinx.coroutines.launch
import me.matsumo.klms.core.model.lms.LmsAccount
import org.jetbrains.compose.resources.stringResource

@Composable
fun LibraryDrawerContent(
    state: DrawerState?,
    account: LmsAccount?,
    currentDestination: NavDestination?,
    navigateToLibraryScreen: (LibraryDestination) -> Unit,
    navigateToSetting: () -> Unit,
    navigateToAbout: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .width(256.dp)
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
    ) {
        NavigationDrawerItem(
            modifier = Modifier.statusBarsPadding(),
            state = state,
            isSelected = currentDestination.isLibraryDestinationInHierarchy(LibraryDestination.Home),
            label = stringResource(Res.string.navigation_home),
            icon = Icons.Outlined.Home,
            selectedIcon = Icons.Default.Home,
            onClick = { navigateToLibraryScreen.invoke(LibraryDestination.Home) },
        )

        NavigationDrawerItem(
            state = state,
            isSelected = currentDestination.isLibraryDestinationInHierarchy(LibraryDestination.Calendar),
            label = stringResource(Res.string.navigation_calendar),
            icon = Icons.Outlined.Search,
            selectedIcon = Icons.Default.Today,
            onClick = { navigateToLibraryScreen.invoke(LibraryDestination.Calendar) },
        )

        NavigationDrawerItem(
            state = state,
            isSelected = currentDestination.isLibraryDestinationInHierarchy(LibraryDestination.Message),
            label = stringResource(Res.string.navigation_message),
            icon = Icons.Outlined.Notifications,
            selectedIcon = Icons.Default.Mail,
            onClick = { navigateToLibraryScreen.invoke(LibraryDestination.Message) },
        )

        NavigationDrawerItem(
            state = state,
            isSelected = currentDestination.isLibraryDestinationInHierarchy(LibraryDestination.Timetable),
            label = stringResource(Res.string.navigation_timetable),
            icon = Icons.Outlined.Mail,
            selectedIcon = Icons.Default.School,
            onClick = { navigateToLibraryScreen.invoke(LibraryDestination.Timetable) },
        )

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        )

        NavigationDrawerItem(
            state = state,
            label = stringResource(Res.string.navigation_settings),
            icon = Icons.Default.Settings,
            onClick = navigateToSetting,
        )

        NavigationDrawerItem(
            state = state,
            label = stringResource(Res.string.navigation_about),
            icon = Icons.Outlined.Info,
            onClick = navigateToAbout,
        )
    }
}

@Composable
private fun NavigationDrawerItem(
    state: DrawerState?,
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    selectedIcon: ImageVector = icon,
) {
    val scope = rememberCoroutineScope()
    val containerColor: Color
    val contentColor: Color

    if (isSelected) {
        containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
        contentColor = MaterialTheme.colorScheme.primary
    } else {
        containerColor = Color.Transparent
        contentColor = MaterialTheme.colorScheme.onSurface
    }

    Row(
        modifier = modifier
            .padding(end = 16.dp)
            .clip(
                RoundedCornerShape(
                    topEnd = 32.dp,
                    bottomEnd = 32.dp,
                ),
            )
            .background(containerColor)
            .clickable {
                scope.launch {
                    state?.close()
                    onClick.invoke()
                }
            }
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = if (isSelected) selectedIcon else icon,
            contentDescription = null,
            tint = contentColor,
        )

        Text(
            modifier = Modifier.weight(1f),
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor,
        )
    }
}
