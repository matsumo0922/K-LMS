package caios.android.klms.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import caios.android.klms.core.ui.extensition.popBackStackWithResult
import caios.android.klms.core.ui.view.simpleAlertDialogDialog
import caios.android.klms.feature.library.LibraryRoute
import caios.android.klms.feature.library.libraryScreen
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
internal fun KlmsNavHost(
    modifier: Modifier = Modifier,
    bottomSheetNavigator: BottomSheetNavigator = rememberBottomSheetNavigator(),
    navController: NavHostController = rememberNavController(bottomSheetNavigator),
    startDestination: String = LibraryRoute,
) {
    ModalBottomSheetLayout(
        modifier = modifier,
        bottomSheetNavigator = bottomSheetNavigator,
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = startDestination,
        ) {
            // composable

            libraryScreen(
                navigateToSettingTop = {  },
                navigateToAbout = {  },
                navigateToBillingPlus = {  },
            )


            // dialog

            simpleAlertDialogDialog(
                terminateWithResult = { navController.popBackStackWithResult(it) },
            )
        }
    }
}
