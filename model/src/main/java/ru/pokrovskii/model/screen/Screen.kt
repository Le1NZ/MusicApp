package ru.pokrovskii.model.screen

sealed interface Screen {

    data class Song(
        val id: Int,
    ) : Screen

    data class Artist(
        val id: String
    ) : Screen

    data class ArtistSongs(
        val id: String,
        val name: String,
    ) : Screen

    data object Search : Screen
    data object Favorites : Screen
    data object Account : Screen
    data object Login : Screen
}
