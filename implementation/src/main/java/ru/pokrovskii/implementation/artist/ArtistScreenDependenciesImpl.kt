package ru.pokrovskii.implementation.artist

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.screen.artist.api.ArtistScreenActions
import ru.pokrovskii.screen.artist.api.ArtistScreenDependencies

internal class ArtistScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : ArtistScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): ArtistScreenActions {
        return ArtistScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
        )
    }
}