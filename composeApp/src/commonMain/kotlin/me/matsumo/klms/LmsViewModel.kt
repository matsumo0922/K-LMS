package me.matsumo.klms

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.repository.LmsAuthRepository
import me.matsumo.klms.core.repository.UserDataRepository

class LmsViewModel(
    private val userDataRepository: UserDataRepository,
    private val lmsAuthRepository: LmsAuthRepository,
) : ViewModel() {

    val screenState = combine(
        userDataRepository.userData,
        lmsAuthRepository.isLoggedIn,
        ::Pair,
    ).map { (userData, isLoggedIn) ->
        ScreenState.Idle(
            LmsUiState(
                userData = userData,
                isLoggedIn = isLoggedIn,
            )
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ScreenState.Loading,
    )

    fun initLmsId() {
        viewModelScope.launch {
            userDataRepository.setLmsId(uuid4().toString())
        }
    }

    fun updateState() {
        viewModelScope.launch {
            lmsAuthRepository.checkLogin()
        }
    }
}

@Stable
data class LmsUiState(
    val userData: UserData,
    val isLoggedIn: Boolean,
)
