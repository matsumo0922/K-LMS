package me.matsumo.klms.screen.welcome.permission

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val WelcomePermissionRoute = "welcomePermission"

fun NavController.navigateToWelcomePermission() {
    this.navigate(WelcomePermissionRoute)
}

fun NavGraphBuilder.welcomePermissionScreen(
    navigateToHome: () -> Unit,
) {
    composable(WelcomePermissionRoute) {
        WelcomePermissionScreen(
            modifier = Modifier.fillMaxSize(),
            navigateToHome = navigateToHome,
        )
    }
}
