package ru.pokrovskii.account_screen.api

import androidx.fragment.app.FragmentManager

interface AccountScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): AccountScreenActions
}