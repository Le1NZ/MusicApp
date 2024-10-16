package ru.pokrovskii.model.screen

sealed interface Screen {

    data object Artist: Screen
    data object Search : Screen
    data object Song: Screen
    data object Favorites: Screen
}