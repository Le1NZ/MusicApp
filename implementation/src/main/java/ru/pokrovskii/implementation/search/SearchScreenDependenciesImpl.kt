package ru.pokrovskii.implementation.search

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.search.api.SearchScreenActions
import ru.pokrovskii.screen.search.api.SearchScreenDependencies

internal class SearchScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : SearchScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): SearchScreenActions {
        return SearchScreenActionsImpl(navigationComponent.createRouter(fragmentManager))
    }
}