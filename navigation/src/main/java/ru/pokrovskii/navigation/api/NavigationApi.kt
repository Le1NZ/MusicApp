package ru.pokrovskii.navigation.api

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.router.AppRouter

object NavigationApi {

    fun createRouter(fragmentManager: FragmentManager): Router {
        return AppRouter(fragmentManager)
    }
}