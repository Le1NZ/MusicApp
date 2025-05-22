package ru.pokrovskii.log_in_screen.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.log_in_screen.ui.LoginScreenFragment

object LoginScreenApi {

    fun createFragment(): Fragment {
        return LoginScreenFragment.newInstance()
    }
}