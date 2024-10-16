package ru.pokrovskii.navigation.api

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.router.AppRouter

class NavigationComponent {

    fun createRouter(
        fragmentManager: FragmentManager,
    ): Router {
        return AppRouter(fragmentManager)
    }
}