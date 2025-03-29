package ru.pokrovskii.implementation.account

import ru.pokrovskii.account_screen.api.AccountScreenActions
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router

internal class AccountScreenActionsImpl(
    private val router: Router,
) : AccountScreenActions {

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }

    override fun onFavoritesClick() {
        router.openScreen(Screen.Favorites)
    }
}