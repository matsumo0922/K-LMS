@file:Suppress("MatchingDeclarationName")

package me.matsumo.klms.core.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LmsNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = LmsNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content,
    )
}

@Composable
fun RowScope.LmsNavigationBarItem(
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    NavigationBarItem(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        icon = icon,
        label = label,
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LmsNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = LmsNavigationDefaults.navigationContentColor(),
            selectedTextColor = LmsNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = LmsNavigationDefaults.navigationContentColor(),
            indicatorColor = LmsNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

@Composable
fun LmsNavigationRail(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        contentColor = LmsNavigationDefaults.navigationContentColor(),
        content = content,
    )
}

@Composable
fun ColumnScope.LmsNavigationRailItem(
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    NavigationRailItem(
        modifier = modifier,
        selected = isSelected,
        onClick = onClick,
        icon = icon,
        label = label,
        alwaysShowLabel = false,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = LmsNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = LmsNavigationDefaults.navigationContentColor(),
            selectedTextColor = LmsNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = LmsNavigationDefaults.navigationContentColor(),
            indicatorColor = LmsNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

object LmsNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}
