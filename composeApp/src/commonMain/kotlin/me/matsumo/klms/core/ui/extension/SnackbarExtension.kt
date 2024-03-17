package me.matsumo.klms.core.ui.extension

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf
import org.jetbrains.compose.resources.StringResource

val LocalSnackbarHostState = staticCompositionLocalOf { SnackbarHostState() }

interface SnackbarExtension {

    suspend fun showSnackbar(
        snackbarHostState: SnackbarHostState,
        message: StringResource,
        isOverride: Boolean = true,
    )

    suspend fun showSnackbar(
        snackbarHostState: SnackbarHostState,
        message: String,
        isOverride: Boolean = true,
    )
}
