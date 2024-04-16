package me.matsumo.klms.screen.library.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import co.touchlab.kermit.Logger
import k_lms.composeapp.generated.resources.Res
import k_lms.composeapp.generated.resources.error_executed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import me.matsumo.klms.core.extensions.suspendRunCatching
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.model.lms.Course
import me.matsumo.klms.core.model.lms.DashboardCard
import me.matsumo.klms.core.repository.LmsRepository
import me.matsumo.klms.core.repository.UserDataRepository

class LibraryHomeViewModel(
    private val userDataRepository: UserDataRepository,
    private val lmsRepository: LmsRepository,
) : ViewModel() {

    val screenState: StateFlow<ScreenState<LibraryHomeUiState>>
        private field: MutableStateFlow<ScreenState<LibraryHomeUiState>> = MutableStateFlow(ScreenState.Loading)

    fun fetch() {
        viewModelScope.launch {
            screenState.value = ScreenState.Loading
            screenState.value = suspendRunCatching {
                lmsRepository.getSyllabusDetail("2024", "40848").also {
                    Logger.d { "SyllabusDetail: $it" }
                }

                LibraryHomeUiState(
                    userData = userDataRepository.userData.first(),
                    coursesPaging = lmsRepository.getCourses(),
                    dashboardCardsPaging = lmsRepository.getDashboardCards(),
                )
            }.fold(
                onSuccess = { ScreenState.Idle(it) },
                onFailure = { ScreenState.Error(Res.string.error_executed) },
            )
        }
    }
}

@Stable
data class LibraryHomeUiState(
    val userData: UserData,
    val coursesPaging: Flow<PagingData<Course>>,
    val dashboardCardsPaging: Flow<PagingData<DashboardCard>>,
)
