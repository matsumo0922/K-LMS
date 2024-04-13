package me.matsumo.klms.screen.library.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.School
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.navigation_calendar
import k_lms.composeapp.generated.resources.navigation_home
import k_lms.composeapp.generated.resources.navigation_message
import k_lms.composeapp.generated.resources.navigation_timetable
import org.jetbrains.compose.resources.StringResource

enum class LibraryDestination(
    val selectedIcon: ImageVector,
    val deselectedIcon: ImageVector,
    val title: StringResource,
) {
    Home(
        selectedIcon = Icons.Default.Home,
        deselectedIcon = Icons.Outlined.Home,
        title = Res.string.navigation_home,
    ),
    Calendar(
        selectedIcon = Icons.Default.Event,
        deselectedIcon = Icons.Outlined.Event,
        title = Res.string.navigation_calendar,
    ),
    Message(
        selectedIcon = Icons.Default.Mail,
        deselectedIcon = Icons.Outlined.Mail,
        title = Res.string.navigation_message,
    ),
    Timetable(
        selectedIcon = Icons.Default.School,
        deselectedIcon = Icons.Outlined.School,
        title = Res.string.navigation_timetable,
    ),
}

internal fun NavDestination?.isLibraryDestinationInHierarchy(destination: LibraryDestination): Boolean {
    return this?.hierarchy?.any { it.route?.contains(destination.name, true) ?: false } == true
}
