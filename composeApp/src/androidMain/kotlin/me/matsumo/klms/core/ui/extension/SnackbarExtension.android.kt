package me.matsumo.klms.core.ui.extension

import android.content.Context
import androidx.compose.material3.SnackbarHostState
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.getString

class SnackbarExtensionImpl(
    private val context: Context,
) : SnackbarExtension {

    override suspend fun showSnackbar(snackbarHostState: SnackbarHostState, message: StringResource, isOverride: Boolean) {
        snackbarHostState.currentSnackbarData?.dismiss()
        snackbarHostState.showSnackbar(getString(message))
    }

    override suspend fun showSnackbar(snackbarHostState: SnackbarHostState, message: String, isOverride: Boolean) {
        snackbarHostState.currentSnackbarData?.dismiss()
        snackbarHostState.showSnackbar(message)
    }
}
