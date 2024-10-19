package ru.pokrovskii.screen.favorites.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.screen.favorites.ui.FavoritesScreenFragment

object FavoritesScreenApi {

    fun createFragment(): Fragment {
        return FavoritesScreenFragment()
    }
}