package ru.pokrovskii.sign_up_screen.api

import androidx.fragment.app.FragmentManager

interface SignUpScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): SignUpScreenActions
}