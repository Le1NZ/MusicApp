package ru.pokrovskii.navigation.api

import ru.pokrovskii.model.screen.Screen

interface Router {

    fun openScreen(screen: Screen)

    fun close()
}