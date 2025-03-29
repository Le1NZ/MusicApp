package ru.pokrovskii.implementation.account

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.account_screen.api.AccountScreenActions
import ru.pokrovskii.account_screen.api.AccountScreenDependencies
import ru.pokrovskii.navigation.api.NavigationComponent

internal class AccountScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : AccountScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): AccountScreenActions {
        return AccountScreenActionsImpl(
            router = navigationComponent.createRouter(
                fragmentManager = fragmentManager,
            ),
        )
    }
}