package ru.pokrovskii.navigation.router

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.api.Router

internal class AppRouter(
    private val fragmentManager: FragmentManager,
) : Router {

    override fun openScreen(screen: Screen) {
        fragmentManager
            .beginTransaction()
            .setCustomAnimations(
                /* enter = */ R.anim.slide_in,
                /* exit = */ R.anim.fade_out,
                /* popEnter = */ R.anim.fade_in,
                /* popExit = */ R.anim.slide_out,
            )
            .replace(R.id.fragment_container, screen.resolveFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun close() {
        fragmentManager.popBackStack()
    }
}