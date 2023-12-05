package caios.android.klms.feature.library.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import caios.android.klms.core.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryHomeViewModel @Inject constructor(
) : ViewModel() {


}

@Stable
data class LibraryUiState(
    val userData: UserData,
)
