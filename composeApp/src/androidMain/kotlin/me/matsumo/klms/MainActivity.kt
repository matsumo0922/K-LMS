package me.matsumo.klms

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import me.matsumo.klms.core.model.ThemeConfig
import me.matsumo.klms.core.repository.UserDataRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : FragmentActivity(), KoinComponent {

    private val userDataRepository: UserDataRepository by inject()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val windowSize = calculateWindowSizeClass()
            val systemUiController = rememberSystemUiController()

            val userData by userDataRepository.userData.collectAsState(null)
            val isSystemInDarkTheme = isSystemInDarkTheme()

            splashScreen.setKeepOnScreenCondition { userData == null }

            if (userData != null) {
                DisposableEffect(systemUiController, userData!!.themeConfig, isSystemInDarkTheme) {
                    systemUiController.systemBarsDarkContentEnabled = (userData!!.themeConfig == ThemeConfig.Light || !isSystemInDarkTheme)
                    onDispose {}
                }

                LmsApp(
                    modifier = Modifier.fillMaxSize(),
                    userData = userData!!,
                    windowWidthSize = windowSize.widthSizeClass,
                )
            }
        }
    }
}
