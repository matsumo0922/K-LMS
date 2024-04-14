package me.matsumo.klms.screen.library

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.error_executed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import me.matsumo.klms.core.extensions.suspendRunCatching
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.model.lms.LmsProfile
import me.matsumo.klms.core.model.lms.LmsUser
import me.matsumo.klms.core.model.updateWhenIdle
import me.matsumo.klms.core.repository.LmsRepository
import me.matsumo.klms.core.repository.UserDataRepository

class LibraryViewModel(
    private val lmsRepository: LmsRepository,
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    val screenState: StateFlow<ScreenState<LibraryUiState>>
       private field: MutableStateFlow<ScreenState<LibraryUiState>> = MutableStateFlow(ScreenState.Loading)

    init {
        viewModelScope.launch {
            userDataRepository.userData.collectLatest {  userData ->
                screenState.value = screenState.updateWhenIdle {
                    it.copy(userData = userData)
                }
            }
        }
    }

    fun fetch() {
        viewModelScope.launch {
            screenState.value = ScreenState.Loading
            screenState.value = suspendRunCatching {
                LibraryUiState(
                    userData = userDataRepository.userData.first(),
                    user = runCatching { lmsRepository.getSelfUser() }.getOrNull(),
                    profile = runCatching { lmsRepository.getSelfProfile() }.getOrNull(),
                )
            }.fold(
                onSuccess = { ScreenState.Idle(it) },
                onFailure = { ScreenState.Error(Res.string.error_executed) },
            )
        }
    }
}

@Stable
data class LibraryUiState(
    val userData: UserData,
    val profile: LmsProfile?,
    val user: LmsUser?,
)
