package ru.pokrovskii.main_screen.api

interface MainScreenActions {

    fun onSearchClick()
    fun onFavoritesClick()
    fun onSongClick(id: Int)
}