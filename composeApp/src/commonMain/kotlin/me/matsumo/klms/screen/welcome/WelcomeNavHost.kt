package me.matsumo.klms.screen.welcome

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.matsumo.klms.screen.welcome.login.WelcomeLoginRoute
import me.matsumo.klms.screen.welcome.login.navigateToWelcomeLogin
import me.matsumo.klms.screen.welcome.login.welcomeLoginScreen
import me.matsumo.klms.screen.welcome.permission.WelcomePermissionRoute
import me.matsumo.klms.screen.welcome.permission.navigateToWelcomePermission
import me.matsumo.klms.screen.welcome.permission.welcomePermissionScreen
import me.matsumo.klms.screen.welcome.top.WelcomeTopRoute
import me.matsumo.klms.screen.welcome.top.welcomeTopScreen

@Composable
fun WelcomeNabHost(
    isAgreedTeams: Boolean,
    isAllowedPermissions: Boolean,
    isLoggedIn: Boolean,
    onComplete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    val startDestination = when {
        !isAgreedTeams -> WelcomeTopRoute
        !isLoggedIn -> WelcomeLoginRoute
        !isAllowedPermissions -> WelcomePermissionRoute
        else -> WelcomeTopRoute
    }

    Scaffold(modifier) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = startDestination,
        ) {
            welcomeTopScreen(
                navigateToWelcomeLogin = {
                    when {
                        !isLoggedIn -> navController.navigateToWelcomeLogin()
                        !isAllowedPermissions -> navController.navigateToWelcomePermission()
                        else -> onComplete.invoke()
                    }
                },
            )

            welcomeLoginScreen(
                navigateToWelcomePermission = {
                    if (isAllowedPermissions) {
                        onComplete.invoke()
                    } else {
                        navController.navigateToWelcomePermission()
                    }
                },
            )

            welcomePermissionScreen(
                navigateToHome = onComplete,
            )
        }
    }
}
