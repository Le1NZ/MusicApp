package ru.pokrovskii.navigation.api

import ru.pokrovskii.model.screen.Screen

interface Router {

    fun openScreen(
        screen: Screen,
        clearBackStack: Boolean = false,
        needAddToBackStack: Boolean = true,
    )

    fun close()
}