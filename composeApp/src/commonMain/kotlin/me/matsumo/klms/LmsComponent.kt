package me.matsumo.klms

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import me.matsumo.klms.screen.library.LibraryComponent
import me.matsumo.klms.screen.welcome.WelcomeLoginComponent

interface LmsComponent {

    val childStack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Library(val component: LibraryComponent) : Child()

        data class WelcomeLogin(val component: WelcomeLoginComponent) : Child()
    }
}

class DefaultLmsComponent(
    private val componentContext: ComponentContext,
) : LmsComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Navigation>()

    private val stack = childStack(
        source = navigation,
        serializer = Navigation.serializer(),
        initialStack = { listOf(Navigation.Library) },
        childFactory = ::childFactory
    )

    override val childStack: Value<ChildStack<*, LmsComponent.Child>> = stack

    private fun childFactory(navigation: Navigation, componentContext: ComponentContext): LmsComponent.Child {
        return when (navigation) {
            is Navigation.Library -> LmsComponent.Child.Library(LibraryComponent(componentContext))
            is Navigation.WelcomeLogin -> LmsComponent.Child.WelcomeLogin(WelcomeLoginComponent(componentContext))
        }
    }

    @Serializable
    sealed interface Navigation {

        @Serializable
        data object Library : Navigation

        @Serializable
        data object WelcomeLogin : Navigation
    }
}
