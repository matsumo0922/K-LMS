package me.matsumo.klms.screen.welcome.top

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val WelcomeTopRoute = "welcomeTop"

fun NavController.navigateToWelcomeTop() {
    this.navigate(WelcomeTopRoute)
}

fun NavGraphBuilder.welcomeTopScreen(
    navigateToWelcomeLogin: () -> Unit,
) {
    composable(WelcomeTopRoute) {
        WelcomeTopRoute(
            modifier = Modifier.fillMaxSize(),
            navigateToWelcomeLogin = navigateToWelcomeLogin,
        )
    }
}
