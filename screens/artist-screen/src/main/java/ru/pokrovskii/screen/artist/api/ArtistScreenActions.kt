package ru.pokrovskii.screen.artist.api

interface ArtistScreenActions {

    fun onAllSongsClick(id: String, name: String)
    fun onSearchClick()
    fun onFavoritesClick()
}