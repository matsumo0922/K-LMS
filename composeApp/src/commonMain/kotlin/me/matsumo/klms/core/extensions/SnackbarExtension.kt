package me.matsumo.klms.core.extensions

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

suspend fun SnackbarHostState.showSnackbar(
    message: StringResource,
    label: StringResource? = null,
    isOverride: Boolean = true,
): SnackbarResult {
    if (isOverride) this.currentSnackbarData?.dismiss()

    return this.showSnackbar(
        message = getString(message),
        actionLabel = label?.let { getString(it) },
        withDismissAction = label != null,
    )
}
