package me.matsumo.klms.screen.library.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import kotlinx.collections.immutable.ImmutableList
import me.matsumo.klms.core.ui.component.LmsNavigationBar
import me.matsumo.klms.core.ui.component.LmsNavigationBarItem
import me.matsumo.klms.core.ui.component.LmsNavigationDefaults
import org.jetbrains.compose.resources.stringResource

@Composable
fun LibraryBottomBar(
    destinations: ImmutableList<LibraryDestination>,
    navigateToDestination: (LibraryDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    LmsNavigationBar(modifier) {
        destinations.forEach { destination ->
            val isSelected = currentDestination.isLibraryDestinationInHierarchy(destination)

            LmsNavigationBarItem(
                isSelected = isSelected,
                onClick = { navigateToDestination(destination) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) destination.selectedIcon else destination.deselectedIcon,
                        contentDescription = stringResource(destination.title),
                        tint = if (isSelected) {
                            LmsNavigationDefaults.navigationSelectedItemColor()
                        } else {
                            LmsNavigationDefaults.navigationContentColor()
                        },
                    )
                },
                label = {
                    Text(
                        text = stringResource(destination.title),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                    )
                },
            )
        }
    }
}
