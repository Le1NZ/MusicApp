package ru.pokrovskii.network.artist_songs.api

sealed interface ArtistSongsSortType {

    data object ByTitle : ArtistSongsSortType
    data object ByPopularity : ArtistSongsSortType
}