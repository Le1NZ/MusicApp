package ru.pokrovskii.screen.search.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.screen.search.ui.SearchScreenFragment

object SearchScreenApi {

    fun createFragment(): Fragment {
        return SearchScreenFragment()
    }
}