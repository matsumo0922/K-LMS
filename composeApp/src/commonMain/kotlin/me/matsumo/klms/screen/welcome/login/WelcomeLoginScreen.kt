package me.matsumo.klms.screen.welcome.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.error_executed
import k_lms.composeapp.generated.resources.vec_welcome_plus
import k_lms.composeapp.generated.resources.welcome_login_button_login
import k_lms.composeapp.generated.resources.welcome_login_button_next
import k_lms.composeapp.generated.resources.welcome_login_email
import k_lms.composeapp.generated.resources.welcome_login_message
import k_lms.composeapp.generated.resources.welcome_login_password
import k_lms.composeapp.generated.resources.welcome_login_ready_message
import k_lms.composeapp.generated.resources.welcome_login_ready_title
import k_lms.composeapp.generated.resources.welcome_login_title
import me.matsumo.klms.core.extensions.koinViewModel
import me.matsumo.klms.core.extensions.showSnackbar
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.theme.LocalSnackbarHostState
import me.matsumo.klms.core.theme.bold
import me.matsumo.klms.core.theme.center
import me.matsumo.klms.core.ui.component.LoadingView
import me.matsumo.klms.screen.welcome.WelcomeIndicatorItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun WelcomeLoginRoute(
    navigateToWelcomePermission: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: WelcomeLoginViewModel = koinViewModel(WelcomeLoginViewModel::class)
) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()
    val snackbarHostState = LocalSnackbarHostState.current

    LaunchedEffect(screenState) {
        if (screenState is ScreenState.Error) {
            snackbarHostState.showSnackbar(Res.string.error_executed)
        }
    }

    Box(modifier) {
        WelcomeLoginScreen(
            modifier = Modifier.fillMaxSize(),
            isLoggedIn = (screenState as? ScreenState.Idle)?.data?.isLoggedIn ?: false,
            onClickLogin = viewModel::login,
            onClickDone = navigateToWelcomePermission,
        )

        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = screenState is ScreenState.Loading,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            LoadingView(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f)),
            )
        }
    }
}

@Composable
private fun WelcomeLoginScreen(
    isLoggedIn: Boolean,
    onClickLogin: (String, String) -> Unit,
    onClickDone: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable() { mutableStateOf("") }
    var isVisiblePassword by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            modifier = Modifier.padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
            ),
            painter = painterResource(Res.drawable.vec_welcome_plus),
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            text = stringResource(if (isLoggedIn) Res.string.welcome_login_ready_title else Res.string.welcome_login_title),
            style = MaterialTheme.typography.displaySmall.bold().center(),
            color = MaterialTheme.colorScheme.primary,
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(if (isLoggedIn) Res.string.welcome_login_ready_message else Res.string.welcome_login_message),
            style = MaterialTheme.typography.bodySmall.center(),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedTextField(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            value = email,
            onValueChange = setEmail,
            label = { Text(stringResource(Res.string.welcome_login_email)) },
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = setPassword,
            label = { Text(stringResource(Res.string.welcome_login_password)) },
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    onClickLogin.invoke(email, password)
                },
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            trailingIcon = {
                IconButton(onClick = { isVisiblePassword = !isVisiblePassword }) {
                    Icon(
                        imageVector = if (isVisiblePassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                    )
                }
            },
            visualTransformation = if (isVisiblePassword) VisualTransformation.None else PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.weight(1f))

        WelcomeIndicatorItem(
            modifier = Modifier.padding(bottom = 24.dp),
            max = 3,
            step = 2,
        )

        if (isLoggedIn) {
            Button(
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth(),
                shape = CircleShape,
                onClick = onClickDone,
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
                onClick = { onClickLogin.invoke(email, password) },
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(Res.string.welcome_login_button_login),
                )
            }
        }
    }
}
