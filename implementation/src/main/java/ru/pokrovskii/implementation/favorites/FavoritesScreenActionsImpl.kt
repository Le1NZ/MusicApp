package ru.pokrovskii.implementation.favorites

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.favorites.api.FavoritesScreenActions

internal class FavoritesScreenActionsImpl(
    private val router: Router,
) : FavoritesScreenActions {

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }

    override fun onAccountClick() {
        router.openScreen(Screen.Account)
    }

    override fun onSongClick(id: Int) {
        router.openScreen(Screen.Song(id))
    }
}