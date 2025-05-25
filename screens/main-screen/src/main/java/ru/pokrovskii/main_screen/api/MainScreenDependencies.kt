package ru.pokrovskii.main_screen.api

import androidx.fragment.app.FragmentManager

interface MainScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): MainScreenActions
}