package me.matsumo.klms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import me.matsumo.klms.core.repository.UserDataRepository
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import platform.UIKit.UIViewController

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun MainViewController() = ComposeUIViewController {
    val userDataRepository = koinInject<UserDataRepository>()
    val userData by userDataRepository.userData.collectAsState(null)

    val windowSize = calculateWindowSizeClass()
    val lmsComponent = DefaultLmsComponent(DefaultComponentContext(LifecycleRegistry()))

    if (userData != null) {
        LmsApp(
            modifier = Modifier.fillMaxSize(),
            component = lmsComponent,
            userData = userData!!,
            windowWidthSize = windowSize.widthSizeClass,
        )
    }
}
