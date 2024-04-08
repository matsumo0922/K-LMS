package me.matsumo.klms

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.theme.MMTheme
import me.matsumo.klms.screen.library.LibraryRoute
import me.matsumo.klms.screen.welcome.WelcomeLoginRoute

@Composable
fun LmsApp(
    component: LmsComponent,
    userData: UserData,
    windowWidthSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    MMTheme(
        themeConfig = userData.themeConfig,
        windowWidthSize = windowWidthSize,
    ) {
        Children(
            modifier = modifier.background(MaterialTheme.colorScheme.surface),
            stack = component.childStack,
        ) {
            when (val child = it.instance) {
                is LmsComponent.Child.Library -> LibraryRoute(child.component)
                is LmsComponent.Child.WelcomeLogin -> WelcomeLoginRoute(child.component)
            }
        }
    }
}
