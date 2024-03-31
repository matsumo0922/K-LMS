package me.matsumo.klms.screen.welcome

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent
import org.koin.core.context.KoinContext

class WelcomeLoginComponent(
    componentContext: ComponentContext
) : KoinComponent, ComponentContext by componentContext {

    private val _isLoggedIn = MutableStateFlow(false)
    private val _triggerLoginError = Channel<Unit>(Channel.BUFFERED)

    val isLoggedIn = _isLoggedIn.asStateFlow()
    val triggerLoginError = _triggerLoginError.receiveAsFlow()
}
