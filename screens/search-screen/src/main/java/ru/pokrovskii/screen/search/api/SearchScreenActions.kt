package ru.pokrovskii.screen.search.api

interface SearchScreenActions {

    fun onFavoritesClick()
    fun onAccountClick()
    fun openSongScreen(id: Int)
}