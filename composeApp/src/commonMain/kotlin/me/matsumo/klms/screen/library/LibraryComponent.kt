package me.matsumo.klms.screen.library

import androidx.compose.runtime.Stable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.repository.LmsAuthRepository
import me.matsumo.klms.core.repository.UserDataRepository
import me.matsumo.klms.core.repository.api.CoursesApi
import me.matsumo.klms.core.utils.MainScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LibraryComponent(
    componentContext: ComponentContext,
) : KoinComponent, ComponentContext by componentContext {

    private val userDataRepository: UserDataRepository by inject()
    private val lmsAuthRepository: LmsAuthRepository by inject()
    private val coursesApi: CoursesApi by inject()
    private val scope: MainScope by inject()

    init {
        lmsAuthRepository.login()

        scope.launch {
            lmsAuthRepository.isLoggedIn.collectLatest {
                if (it) {
                    coursesApi.getCourse()
                }
            }
        }
    }

    val screenState = userDataRepository.userData.map {
        ScreenState.Idle(
            HomeUiState(
                userData = it,
            ),
        )
    }.stateIn(
        scope = coroutineScope(),
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ScreenState.Loading,
    )
}

@Stable
data class HomeUiState(
    val userData: UserData,
)
