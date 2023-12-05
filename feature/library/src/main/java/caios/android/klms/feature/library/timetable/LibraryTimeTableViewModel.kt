package caios.android.klms.feature.library.timetable

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import caios.android.klms.core.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryTimeTableViewModel @Inject constructor(
) : ViewModel() {


}

@Stable
data class LibraryTimeTableUiState(
    val userData: UserData,
)
