package ru.pokrovskii.implementation.song

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.song.api.SongScreenActions

internal class SongScreenActionsImpl(
    private val router: Router,
) : SongScreenActions {

    override fun onFavoriteClick() {
        router.openScreen(Screen.Favorites)
    }

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }
}