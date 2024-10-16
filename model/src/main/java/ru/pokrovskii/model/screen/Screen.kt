package ru.pokrovskii.model.screen

sealed interface Screen {

    data object Search : Screen

    data class Song(
        val id: Int,
    ) : Screen

    data object Favorites: Screen
}