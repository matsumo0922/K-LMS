package caios.android.klms.feature.library.course

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import caios.android.klms.core.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryCourseViewModel @Inject constructor(
) : ViewModel() {


}

@Stable
data class LibraryCourseUiState(
    val userData: UserData,
)
