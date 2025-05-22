package ru.pokrovskii.implementation.sign_up

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.sign_up_screen.api.SignUpScreenActions
import ru.pokrovskii.sign_up_screen.api.SignUpScreenDependencies

internal class SignUpScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : SignUpScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): SignUpScreenActions {
        return SignUpScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
        )
    }
}