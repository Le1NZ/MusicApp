package ru.pokrovskii.implementation.auth

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.log_in_screen.api.LoginScreenActions
import ru.pokrovskii.log_in_screen.api.LoginScreenDependencies
import ru.pokrovskii.navigation.api.NavigationComponent

internal class LoginScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : LoginScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): LoginScreenActions {
        return LoginScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
        )
    }
}