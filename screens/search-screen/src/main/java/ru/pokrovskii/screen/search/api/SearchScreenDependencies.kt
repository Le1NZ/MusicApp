package ru.pokrovskii.screen.search.api

import androidx.fragment.app.FragmentManager

interface SearchScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): SearchScreenActions
}