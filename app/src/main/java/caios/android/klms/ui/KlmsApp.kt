package caios.android.klms.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import caios.android.klms.MainViewModel
import caios.android.klms.core.model.UserData
import caios.android.klms.core.ui.component.KlmsBackground
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi

@Composable
internal fun KlmsApp(
    userData: UserData,
    isAgreedTerms: Boolean,
    isAllowedPermission: Boolean,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    LaunchedEffect(true) {
        if (userData.klmsId.isBlank()) {
            viewModel.initKlmsId()
        }
    }

    KlmsBackground(modifier) {
        IdleScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)
@Composable
private fun IdleScreen(
    modifier: Modifier = Modifier,
) {
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true)
    val bottomSheetNavigator = remember { BottomSheetNavigator(bottomSheetState) }
    val navController = rememberNavController(bottomSheetNavigator)

    KlmsNavHost(
        modifier = modifier,
        bottomSheetNavigator = bottomSheetNavigator,
        navController = navController,
    )
}
