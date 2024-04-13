package me.matsumo.klms

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.matsumo.klms.core.extensions.koinViewModel
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.theme.MMTheme
import me.matsumo.klms.core.ui.AsyncLoadContents
import org.koin.compose.KoinContext

@Composable
fun LmsApp(
    userData: UserData,
    windowWidthSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    KoinContext {
        MMTheme(
            themeConfig = userData.themeConfig,
            windowWidthSize = windowWidthSize,
        ) {
            val viewModel = koinViewModel(LmsViewModel::class)
            val screenState by viewModel.screenState.collectAsStateWithLifecycle()

            AsyncLoadContents(
                modifier = modifier.background(MaterialTheme.colorScheme.surface),
                screenState = screenState,
            ) {
                LmsScreen(
                    uiState = it,
                    onRequestLmsId = viewModel::initLmsId,
                    onRequestUpdateState = viewModel::updateState,
                )
            }
        }
    }
}
