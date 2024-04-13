package me.matsumo.klms

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import me.matsumo.klms.screen.welcome.WelcomeNabHost

@Composable
fun LmsScreen(
    uiState: LmsUiState,
    onRequestLmsId: () -> Unit,
    onRequestUpdateState: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isAgreedTeams by remember(uiState.userData) { mutableStateOf(uiState.userData.isAgreedPrivacyPolicy && uiState.userData.isAgreedTermsOfService) }
    var isAllowedPermissions by remember(uiState.userData, uiState.isLoggedIn) { mutableStateOf(true) }

    LaunchedEffect(true) {
        if (uiState.userData.lmsId.isBlank()) {
            onRequestLmsId.invoke()
        }
    }

    AnimatedContent(
        modifier = modifier,
        targetState = !isAgreedTeams || !uiState.isLoggedIn || !isAllowedPermissions,
        transitionSpec = { fadeIn().togetherWith(fadeOut()) },
        label = "isShowWelcomeScreen",
    ) {
        if (it) {
            WelcomeNabHost(
                modifier = Modifier.fillMaxSize(),
                isAgreedTeams = isAgreedTeams,
                isAllowedPermissions = isAllowedPermissions,
                isLoggedIn = uiState.isLoggedIn,
                onComplete = {
                    isAgreedTeams = true
                    isAllowedPermissions = true

                    onRequestUpdateState.invoke()
                }
            )
        } else {
            LmsNavHost(
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
