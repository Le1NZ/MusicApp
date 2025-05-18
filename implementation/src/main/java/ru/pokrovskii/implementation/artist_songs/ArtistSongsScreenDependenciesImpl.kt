package ru.pokrovskii.implementation.artist_songs

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenActions
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenDependencies

internal class ArtistSongsScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : ArtistSongsScreenDependencies {

    override fun createActions(fragmentManager: FragmentManager): ArtistSongsScreenActions {
        return ArtistSongsScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
        )
    }
}