package ru.pokrovskii.navigation.router

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.api.Router

internal class AppRouter(
    private val fragmentManager: FragmentManager,
): Router {

    override fun openScreen(screen: Screen) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, screen.resolveFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun close() {
        fragmentManager.popBackStack()
    }
}