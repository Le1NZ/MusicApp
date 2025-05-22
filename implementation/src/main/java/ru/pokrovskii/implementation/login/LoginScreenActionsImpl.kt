package ru.pokrovskii.implementation.login

import ru.pokrovskii.log_in_screen.api.LoginScreenActions
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router

internal class LoginScreenActionsImpl(
    private val router: Router,
) : LoginScreenActions {

    override fun onLoginSuccess() {
        router.openScreen(Screen.Favorites)
    }

    override fun toSignUp() {
        router.openScreen(Screen.SignUp)
    }
}