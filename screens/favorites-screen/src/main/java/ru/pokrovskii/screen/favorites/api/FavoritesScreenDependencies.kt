package ru.pokrovskii.screen.favorites.api

import androidx.fragment.app.FragmentManager

interface FavoritesScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): FavoritesScreenActions
}