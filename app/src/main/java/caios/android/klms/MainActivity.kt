package caios.android.klms

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import caios.android.klms.core.model.ScreenState
import caios.android.klms.core.model.ThemeConfig
import caios.android.klms.core.ui.AsyncLoadContents
import caios.android.klms.core.ui.theme.DarkDefaultColorScheme
import caios.android.klms.core.ui.theme.KlmsTheme
import caios.android.klms.core.ui.theme.LightDefaultColorScheme
import caios.android.klms.ui.KlmsApp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val screenState by viewModel.screenState.collectAsStateWithLifecycle()
            val systemUiController = rememberSystemUiController()
            val shouldUseDarkTheme = shouldUseDarkTheme(screenState)

            splashScreen.setKeepOnScreenCondition {
                when (screenState) {
                    is ScreenState.Loading -> true
                    else -> false
                }
            }

            DisposableEffect(systemUiController, shouldUseDarkTheme) {
                systemUiController.systemBarsDarkContentEnabled = !shouldUseDarkTheme
                onDispose {}
            }

            AsyncLoadContents(
                modifier = Modifier.fillMaxSize(),
                screenState = screenState,
                containerColor = if (shouldUseDarkTheme) DarkDefaultColorScheme.surface else LightDefaultColorScheme.surface,
            ) {
                val isAgreedTeams = remember(it.userData) { it.userData.isAgreedPrivacyPolicy && it.userData.isAgreedTermsOfService }
                val isAllowedPermission = remember(it.userData) { isAllowedPermission() }

                KlmsTheme(
                    themeColorConfig = it.userData.themeColorConfig,
                    shouldUseDarkTheme = shouldUseDarkTheme,
                    enableDynamicTheme = shouldUseDynamicColor(screenState),
                ) {
                    KlmsApp(
                        modifier = Modifier.fillMaxSize(),
                        viewModel = viewModel,
                        userData = it.userData,
                        isAgreedTerms = isAgreedTeams,
                        isAllowedPermission = isAllowedPermission,
                    )
                }
            }
        }
    }

    @Composable
    private fun shouldUseDarkTheme(screenState: ScreenState<MainUiState>): Boolean {
        return when (screenState) {
            is ScreenState.Idle -> when (screenState.data.userData.themeConfig) {
                ThemeConfig.Light -> false
                ThemeConfig.Dark -> true
                else -> isSystemInDarkTheme()
            }

            else -> isSystemInDarkTheme()
        }
    }

    @Composable
    private fun shouldUseDynamicColor(screenState: ScreenState<MainUiState>): Boolean {
        return when (screenState) {
            is ScreenState.Idle -> screenState.data.userData.isDynamicColor
            else -> false
        }
    }

    private fun isAllowedPermission(): Boolean {
        val storagePermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(
                android.Manifest.permission.READ_MEDIA_IMAGES,
                android.Manifest.permission.READ_MEDIA_VIDEO,
            )
        } else {
            listOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        return storagePermission.all {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }
    }
}
