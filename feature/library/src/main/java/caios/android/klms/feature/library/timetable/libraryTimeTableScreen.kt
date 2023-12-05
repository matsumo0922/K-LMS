package caios.android.klms.feature.library.timetable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
internal fun LibraryTimeTableScreen(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LibraryTimeTableViewModel = hiltViewModel(),
) {
    Box(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
    )
}
