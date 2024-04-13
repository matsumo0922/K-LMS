package me.matsumo.klms.screen.welcome.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val WelcomeLoginRoute = "welcomeLogin"

fun NavController.navigateToWelcomeLogin() {
    this.navigate(WelcomeLoginRoute)
}

fun NavGraphBuilder.welcomeLoginScreen(
    navigateToWelcomePermission: () -> Unit,
) {
    composable(WelcomeLoginRoute) {
        WelcomeLoginRoute(
            modifier = Modifier.fillMaxSize(),
            navigateToWelcomePermission = navigateToWelcomePermission,
        )
    }
}
