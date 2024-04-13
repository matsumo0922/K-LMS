package me.matsumo.klms.screen.welcome.top

import androidx.lifecycle.ViewModel
import me.matsumo.klms.core.repository.UserDataRepository

class WelcomeTopViewModel(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    suspend fun setAgreedPrivacyPolicy() {
        userDataRepository.setAgreedPrivacyPolicy(true)
    }

    suspend fun setAgreedTermsOfService() {
        userDataRepository.setAgreedTermsOfService(true)
    }
}
