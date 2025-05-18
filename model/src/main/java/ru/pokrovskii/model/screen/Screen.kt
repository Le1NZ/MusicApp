package ru.pokrovskii.model.screen

sealed interface Screen {

    data class Song(
        val id: Int,
    ) : Screen

    data class Artist(
        val id: String
    ) : Screen

    data object Search : Screen
    data object Favorites : Screen
    data object Account : Screen
}
