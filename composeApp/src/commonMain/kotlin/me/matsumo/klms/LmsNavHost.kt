package me.matsumo.klms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.matsumo.klms.core.ui.component.BottomSheetNavigator
import me.matsumo.klms.core.ui.component.ModalBottomSheetLayout
import me.matsumo.klms.screen.library.LibraryRoute
import me.matsumo.klms.screen.library.libraryScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LmsNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = LibraryRoute,
) {
   val navController = rememberNavController()

    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, skipHalfExpanded = true)
    val bottomSheetNavigator = remember { BottomSheetNavigator(bottomSheetState) }

    ModalBottomSheetLayout(
        modifier = modifier,
        bottomSheetNavigator = bottomSheetNavigator,
    ) {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = startDestination,
        ) {
            libraryScreen()
        }
    }
}
