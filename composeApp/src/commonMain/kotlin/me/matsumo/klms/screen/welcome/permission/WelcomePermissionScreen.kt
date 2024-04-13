package me.matsumo.klms.screen.welcome.permission

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.compose.BindEffect
import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.vec_welcome_permission
import k_lms.composeapp.generated.resources.welcome_permission_allow_button
import k_lms.composeapp.generated.resources.welcome_permission_allowed
import k_lms.composeapp.generated.resources.welcome_permission_complete_button
import k_lms.composeapp.generated.resources.welcome_permission_denied
import k_lms.composeapp.generated.resources.welcome_permission_message
import k_lms.composeapp.generated.resources.welcome_permission_notification
import k_lms.composeapp.generated.resources.welcome_permission_notification_message
import k_lms.composeapp.generated.resources.welcome_permission_optional
import k_lms.composeapp.generated.resources.welcome_permission_ready_message
import k_lms.composeapp.generated.resources.welcome_permission_ready_title
import k_lms.composeapp.generated.resources.welcome_permission_storage
import k_lms.composeapp.generated.resources.welcome_permission_storage_message
import k_lms.composeapp.generated.resources.welcome_permission_title
import kotlinx.coroutines.launch
import me.matsumo.klms.core.theme.bold
import me.matsumo.klms.core.theme.center
import me.matsumo.klms.screen.welcome.WelcomeIndicatorItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomePermissionScreen(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val factory: PermissionsControllerFactory = rememberPermissionsControllerFactory()
    val controller: PermissionsController = remember(factory) { factory.createPermissionsController() }

    var isGrantedStorage by remember { mutableStateOf(false) }
    var isGrantedNotify by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        isGrantedStorage = controller.isPermissionGranted(Permission.STORAGE)
        isGrantedNotify = controller.isPermissionGranted(Permission.REMOTE_NOTIFICATION)
    }

    BindEffect(controller)

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
            ),
            painter = painterResource(Res.drawable.vec_welcome_permission),
            contentDescription = null,
        )

        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(if (isGrantedStorage) Res.string.welcome_permission_ready_title else Res.string.welcome_permission_title),
            style = MaterialTheme.typography.displaySmall.bold(),
        )

        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = stringResource(if (isGrantedStorage) Res.string.welcome_permission_ready_message else Res.string.welcome_permission_message),
            style = MaterialTheme.typography.bodySmall.center(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Column(
            modifier = Modifier.padding(top = 48.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            WelcomePermissionItem(
                isAllowed = isGrantedStorage,
                isOptional = false,
                title = stringResource(Res.string.welcome_permission_storage),
                message = stringResource(Res.string.welcome_permission_storage_message),
            )

            WelcomePermissionItem(
                isAllowed = isGrantedNotify,
                isOptional = true,
                title = stringResource(Res.string.welcome_permission_notification),
                message = stringResource(Res.string.welcome_permission_notification_message),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        WelcomeIndicatorItem(
            modifier = Modifier.padding(bottom = 24.dp),
            max = 3,
            step = 3,
        )

        if (isGrantedStorage) {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                onClick = { navigateToHome.invoke() },
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(Res.string.welcome_permission_complete_button),
                )
            }
        } else {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                onClick = {
                    scope.launch {
                        try {
                            when {
                                !isGrantedStorage -> controller.providePermission(Permission.STORAGE)
                                !isGrantedNotify -> controller.providePermission(Permission.REMOTE_NOTIFICATION)
                            }
                        } catch (deniedAlways: DeniedAlwaysException) {
                            Logger.e("Denied permission always.", deniedAlways)
                            controller.openAppSettings()
                        } catch (denied: DeniedException) {
                            // do nothing
                        } finally {
                            isGrantedStorage = controller.isPermissionGranted(Permission.STORAGE)
                            isGrantedNotify = controller.isPermissionGranted(Permission.REMOTE_NOTIFICATION)
                        }
                    }
                },
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(Res.string.welcome_permission_allow_button),
                )
            }
        }
    }
}

@Composable
private fun WelcomePermissionItem(
    isAllowed: Boolean,
    isOptional: Boolean,
    title: String,
    message: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        WelcomePermissionLabel(
            modifier = Modifier.width(72.dp),
            isAllowed = isAllowed,
            isOptional = isOptional,
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun WelcomePermissionLabel(
    isAllowed: Boolean,
    isOptional: Boolean,
    modifier: Modifier = Modifier,
) {
    val color = when {
        isAllowed -> MaterialTheme.colorScheme.primary
        isOptional -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = color,
                shape = CircleShape,
            ),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            text = when {
                isAllowed -> stringResource(Res.string.welcome_permission_allowed)
                isOptional -> stringResource(Res.string.welcome_permission_optional)
                else -> stringResource(Res.string.welcome_permission_denied)
            },
            style = MaterialTheme.typography.labelSmall,
            color = color,
        )
    }
}
