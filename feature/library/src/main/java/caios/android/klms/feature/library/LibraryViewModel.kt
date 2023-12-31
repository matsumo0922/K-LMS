package caios.android.fanbox.feature.library

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import caios.android.klms.core.model.ScreenState
import caios.android.klms.core.model.UserData
import caios.android.klms.core.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    userDataRepository: UserDataRepository,
) : ViewModel() {

    val screenState = userDataRepository.userData.map {
        ScreenState.Idle(
            LibraryUiState(
                userData = it,
            ),
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ScreenState.Loading,
    )
}

@Stable
data class LibraryUiState(
    val userData: UserData,
)
