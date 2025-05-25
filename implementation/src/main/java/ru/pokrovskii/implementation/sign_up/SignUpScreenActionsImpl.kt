package ru.pokrovskii.implementation.sign_up

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.sign_up_screen.api.SignUpScreenActions

internal class SignUpScreenActionsImpl(
    private val router: Router,
) : SignUpScreenActions {

    override fun onSignUpSuccess() {
        router.openScreen(
            screen = Screen.Landing,
            clearBackStack = true,
        )
    }

    override fun toLogin() {
        router.openScreen(Screen.Login)
    }
}