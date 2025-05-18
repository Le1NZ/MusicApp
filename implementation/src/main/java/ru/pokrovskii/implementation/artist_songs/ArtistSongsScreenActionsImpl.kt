package ru.pokrovskii.implementation.artist_songs

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenActions

internal class ArtistSongsScreenActionsImpl(
    private val router: Router,
) : ArtistSongsScreenActions {

    override fun onSongClick(id: Int) {
        router.openScreen(Screen.Song(id = id))
    }

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }

    override fun onFavoritesClick() {
        router.openScreen(Screen.Favorites)
    }
}