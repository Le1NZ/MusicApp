package ru.pokrovskii.account_screen.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.account_screen.ui.AccountScreenFragment

object AccountScreenApi {

    fun createFragment(): Fragment {
        return AccountScreenFragment()
    }
}