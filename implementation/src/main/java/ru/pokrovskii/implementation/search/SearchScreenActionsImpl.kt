package ru.pokrovskii.implementation.search

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.search.api.SearchScreenActions

internal class SearchScreenActionsImpl(
    private val router: Router,
) : SearchScreenActions {

    override fun onFavoritesClick() {
        router.openScreen(Screen.Favorites)
    }

    override fun onAccountClick() {
        router.openScreen(Screen.Account)
    }

    override fun openSongScreen(id: Int) {
        router.openScreen(Screen.Song(id))
    }
}