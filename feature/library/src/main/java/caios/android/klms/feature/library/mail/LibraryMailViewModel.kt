package caios.android.klms.feature.library.mail

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import caios.android.klms.core.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LibraryMailViewModel @Inject constructor(
) : ViewModel() {


}

@Stable
data class LibraryMailUiState(
    val userData: UserData,
)
