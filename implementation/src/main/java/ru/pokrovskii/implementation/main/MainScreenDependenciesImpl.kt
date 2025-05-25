package ru.pokrovskii.implementation.main

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.main_screen.api.MainScreenActions
import ru.pokrovskii.main_screen.api.MainScreenDependencies
import ru.pokrovskii.navigation.api.NavigationComponent

internal class MainScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : MainScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): MainScreenActions {
        return MainScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
        )
    }
}