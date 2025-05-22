package ru.pokrovskii.log_in_screen.api

import androidx.fragment.app.FragmentManager

interface LoginScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): LoginScreenActions
}