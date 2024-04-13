package me.matsumo.klms.screen.welcome

import me.matsumo.klms.screen.welcome.login.WelcomeLoginViewModel
import me.matsumo.klms.screen.welcome.top.WelcomeTopViewModel
import org.koin.dsl.module

val welcomeModule = module {

    factory {
        WelcomeTopViewModel(
            userDataRepository = get(),
        )
    }

    factory {
        WelcomeLoginViewModel(
            lmsAuthRepository = get(),
            lmsRepository = get(),
        )
    }
}
