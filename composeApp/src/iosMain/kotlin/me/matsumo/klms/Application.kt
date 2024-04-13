package me.matsumo.klms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import me.matsumo.klms.core.repository.UserDataRepository
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun MainViewController() = ComposeUIViewController {
    val userDataRepository = koinInject<UserDataRepository>()
    val userData by userDataRepository.userData.collectAsState(null)

    val windowSize = calculateWindowSizeClass()

    if (userData != null) {
        LmsApp(
            modifier = Modifier.fillMaxSize(),
            userData = userData!!,
            windowWidthSize = windowSize.widthSizeClass,
        )
    }
}
