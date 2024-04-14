package me.matsumo.klms.screen.welcome.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.error_executed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.matsumo.klms.core.extensions.suspendRunCatching
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.lms.LmsAccount
import me.matsumo.klms.core.model.lms.LmsUser
import me.matsumo.klms.core.repository.LmsAuthRepository
import me.matsumo.klms.core.repository.LmsRepository

class WelcomeLoginViewModel(
    private val lmsAuthRepository: LmsAuthRepository,
    private val lmsRepository: LmsRepository,
) : ViewModel() {

    val screenState: StateFlow<ScreenState<WelcomeLoginUiState>>
      private field: MutableStateFlow<ScreenState<WelcomeLoginUiState>> = MutableStateFlow(ScreenState.Idle(WelcomeLoginUiState()))

    fun login(email: String, password: String) {
        viewModelScope.launch {
            screenState.value = ScreenState.Loading
            screenState.value = suspendRunCatching {
                lmsAuthRepository.setLoginParams(email, password, "")
                lmsAuthRepository.login()

                WelcomeLoginUiState(
                    lmsUser = lmsRepository.getSelfUser(),
                    lmsAccount = lmsRepository.getSelfAccount(),
                )
            }
                .onFailure { lmsAuthRepository.setLoginParams("", "", "") }
                .fold(
                    onSuccess = { ScreenState.Idle(it.copy(isLoggedIn = true)) },
                    onFailure = { ScreenState.Error(Res.string.error_executed) },
                )
        }
    }
}

data class WelcomeLoginUiState(
    val isLoggedIn: Boolean = false,
    val lmsUser: LmsUser? = null,
    val lmsAccount: LmsAccount? = null,
)
