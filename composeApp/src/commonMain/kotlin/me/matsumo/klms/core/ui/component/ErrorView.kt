package me.matsumo.klms.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.common_reload
import k_lms.composeapp.generated.resources.error_executed
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.theme.bold
import me.matsumo.klms.core.theme.center
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ErrorView(
    title: StringResource,
    message: StringResource,
    modifier: Modifier = Modifier,
    retryTitle: StringResource? = null,
    retryAction: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterVertically,
        ),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium.bold().center(),
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(message),
            style = MaterialTheme.typography.bodyMedium.center(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        if (retryAction != null) {
            Button(
                modifier = Modifier.padding(top = 24.dp),
                onClick = { retryAction.invoke() },
            ) {
                Text(
                    text = stringResource(retryTitle ?: Res.string.common_reload),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }
}

@Composable
fun ErrorView(
    errorState: ScreenState.Error,
    retryAction: (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    ErrorView(
        modifier = modifier,
        title = Res.string.error_executed,
        message = errorState.message,
        retryTitle = errorState.retryTitle,
        retryAction = retryAction,
    )
}
