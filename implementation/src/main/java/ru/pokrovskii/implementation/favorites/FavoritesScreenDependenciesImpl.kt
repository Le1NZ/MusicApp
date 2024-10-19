package ru.pokrovskii.implementation.favorites

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.screen.favorites.api.FavoritesScreenActions
import ru.pokrovskii.screen.favorites.api.FavoritesScreenDependencies

internal class FavoritesScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : FavoritesScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): FavoritesScreenActions {
        return FavoritesScreenActionsImpl(navigationComponent.createRouter(fragmentManager))
    }
}