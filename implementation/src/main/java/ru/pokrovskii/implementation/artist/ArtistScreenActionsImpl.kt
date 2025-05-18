package ru.pokrovskii.implementation.artist

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.artist.api.ArtistScreenActions

internal class ArtistScreenActionsImpl(
    private val router: Router,
) : ArtistScreenActions {

    override fun onAllSongsClick(id: String, name: String) {
        router.openScreen(
            screen = Screen.ArtistSongs(
                id = id,
                name = name,
            ),
        )
    }

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }

    override fun onFavoritesClick() {
        router.openScreen(Screen.Favorites)
    }
}