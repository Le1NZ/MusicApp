package ru.pokrovskii.screen.song.api

interface SongScreenActions {

    fun onFavoriteClick()
    fun onSearchClick()
    fun onToTextButtonClick(url: String)
}