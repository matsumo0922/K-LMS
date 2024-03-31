package me.matsumo.klms.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.vec_welcome_plus
import k_lms.composeapp.generated.resources.welcome_login_button_login
import k_lms.composeapp.generated.resources.welcome_login_button_next
import k_lms.composeapp.generated.resources.welcome_login_message
import k_lms.composeapp.generated.resources.welcome_login_ready_message
import k_lms.composeapp.generated.resources.welcome_login_ready_title
import k_lms.composeapp.generated.resources.welcome_login_title
import me.matsumo.klms.core.theme.bold
import me.matsumo.klms.core.theme.center
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeLoginScreen(
    component: WelcomeLoginComponent,
    modifier: Modifier = Modifier,
) {
    val isLoggedIn by component.isLoggedIn.collectAsState()
    val isLoginError by component.triggerLoginError.collectAsState(-1)

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = modifier.padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
            ),
            painter = painterResource(Res.drawable.vec_welcome_plus),
            contentDescription = null,
        )

        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(if (isLoggedIn) Res.string.welcome_login_ready_title else Res.string.welcome_login_title),
            style = MaterialTheme.typography.displaySmall.bold(),
            color = MaterialTheme.colorScheme.primary,
        )

        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = stringResource(if (isLoggedIn) Res.string.welcome_login_ready_message else Res.string.welcome_login_message),
            style = MaterialTheme.typography.bodySmall.center(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Spacer(modifier = Modifier.weight(1f))

        if (isLoggedIn) {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                onClick = { },
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(Res.string.welcome_login_button_next),
                )
            }
        } else {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                onClick = { },
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(Res.string.welcome_login_button_login),
                )
            }
        }
    }
}
