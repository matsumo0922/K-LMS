package me.matsumo.klms.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import me.matsumo.klms.core.extensions.LocalStateHolder
import me.matsumo.klms.core.extensions.StateHolder
import me.matsumo.klms.core.model.ThemeConfig
import me.matsumo.klms.core.theme.color.DarkBlueColorScheme
import me.matsumo.klms.core.theme.color.LightBlueColorScheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun MMTheme(
    themeConfig: ThemeConfig = ThemeConfig.System,
    windowWidthSize: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    content: @Composable () -> Unit,
) {
    val shouldUseDarkTheme = when (themeConfig) {
        ThemeConfig.System -> isSystemInDarkTheme()
        ThemeConfig.Light -> false
        ThemeConfig.Dark -> true
    }

    CompositionLocalProvider(
        LocalWindowWidthSize provides windowWidthSize,
        LocalThemeConfig provides themeConfig,
        LocalStateHolder provides remember { StateHolder() },
        LocalSnackbarHostState provides remember { SnackbarHostState() },
    ) {
        MaterialTheme(
            colorScheme = if (shouldUseDarkTheme) DarkBlueColorScheme else LightBlueColorScheme,
            typography = LmsTypography,
            shapes = LmsShapes,
            content = content,
        )
    }
}

val LocalWindowWidthSize = staticCompositionLocalOf { WindowWidthSizeClass.Compact }
val LocalThemeConfig = staticCompositionLocalOf { ThemeConfig.System }
val LocalSnackbarHostState = staticCompositionLocalOf { SnackbarHostState() }
