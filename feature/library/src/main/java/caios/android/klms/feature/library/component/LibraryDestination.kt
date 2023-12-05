package caios.android.klms.feature.library.component

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import caios.android.klms.feature.library.R

internal enum class LibraryDestination(
    val selectedIcon: ImageVector,
    val deselectedIcon: ImageVector,
    @StringRes val title: Int,
) {
    Home(
        selectedIcon = Icons.Default.Home,
        deselectedIcon = Icons.Outlined.Home,
        title = R.string.library_navigation_home,
    ),
    Course(
        selectedIcon = Icons.AutoMirrored.Filled.MenuBook,
        deselectedIcon = Icons.AutoMirrored.Outlined.MenuBook,
        title = R.string.library_navigation_course,
    ),
    Mail(
        selectedIcon = Icons.Default.Mail,
        deselectedIcon = Icons.Outlined.Mail,
        title = R.string.library_navigation_mail,
    ),
    TimeTable(
        selectedIcon = Icons.Default.AccessTimeFilled,
        deselectedIcon = Icons.Outlined.AccessTime,
        title = R.string.library_navigation_timetable,
    ),
}

internal fun NavDestination?.isLibraryDestinationInHierarchy(destination: LibraryDestination): Boolean {
    return this?.hierarchy?.any { it.route?.contains(destination.name, true) ?: false } == true
}
