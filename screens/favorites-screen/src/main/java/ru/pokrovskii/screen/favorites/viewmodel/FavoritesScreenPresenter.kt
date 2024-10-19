package ru.pokrovskii.screen.favorites.viewmodel

import ru.pokrovskii.screen.favorites.api.FavoritesScreenActions

internal interface FavoritesScreenPresenter {

    fun onSongClick(id: Int)
    fun onSearchClick()
}

internal class FavoritesScreenPresenterImpl(
    private val actions: FavoritesScreenActions,
) : FavoritesScreenPresenter {

    override fun onSongClick(id: Int) {
        actions.onSongClick(id)
    }

    override fun onSearchClick() {
        actions.onSearchClick()
    }
}

internal class FavoritesScreenPresenterPreview : FavoritesScreenPresenter {

    override fun onSongClick(id: Int) = Unit
    override fun onSearchClick() = Unit
}