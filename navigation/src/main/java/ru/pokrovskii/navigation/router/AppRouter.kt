package ru.pokrovskii.navigation.router

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.api.Router

internal class AppRouter(
    private val fragmentManager: FragmentManager,
) : Router {

    override fun openScreen(
        screen: Screen,
        clearBackStack: Boolean,
    ) {
        fragmentManager.commit {
            setCustomAnimations(
                /* enter = */ R.anim.slide_in,
                /* exit = */ R.anim.fade_out,
                /* popEnter = */ R.anim.fade_in,
                /* popExit = */ R.anim.slide_out,
            )

            addToBackStack(null)
            replace(R.id.fragment_container, screen.resolveFragment())

            if (clearBackStack) {
                fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

    override fun close() {
        fragmentManager.popBackStack()
    }
}