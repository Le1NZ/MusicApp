package ru.pokrovskii.navigation.router

import androidx.fragment.app.Fragment
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.screen.search.api.SearchScreenApi

internal fun Screen.resolveFragment(): Fragment {
    return when (this) {
        Screen.Search -> SearchScreenApi.createFragment()
        else -> SearchScreenApi.createFragment() // TODO make others api
    }
}