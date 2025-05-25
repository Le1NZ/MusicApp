package ru.pokrovskii.main_screen.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.main_screen.ui.MainScreenFragment

object MainScreenApi {

    fun createFragment(): Fragment {
        return MainScreenFragment.newInstance()
    }
}