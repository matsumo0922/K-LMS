package me.matsumo.klms.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import me.matsumo.klms.core.model.ThemeConfig
import me.matsumo.klms.core.theme.color.*

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
    ) {
        MaterialTheme(
            colorScheme = if (shouldUseDarkTheme) DarkBlueColorScheme else LightBlueColorScheme,
            typography = LmsTypography,
            shapes = LmsShapes,
            content = content,
        )
    }
}

val LocalWindowWidthSize = staticCompositionLocalOf<WindowWidthSizeClass> { WindowWidthSizeClass.Compact }
val LocalThemeConfig = staticCompositionLocalOf { ThemeConfig.System }
