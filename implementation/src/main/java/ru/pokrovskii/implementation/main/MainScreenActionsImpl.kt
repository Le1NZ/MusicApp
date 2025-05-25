package ru.pokrovskii.implementation.main

import ru.pokrovskii.main_screen.api.MainScreenActions
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router

internal class MainScreenActionsImpl(
    private val router: Router,
) : MainScreenActions {

    override fun onSearchClick() {
        router.openScreen(screen = Screen.Search)
    }

    override fun onFavoritesClick() {
        router.openScreen(screen = Screen.Favorites)
    }

    override fun onSongClick(id: Int) {
        router.openScreen(
            screen = Screen.Song(
                id = id,
            ),
        )
    }
}