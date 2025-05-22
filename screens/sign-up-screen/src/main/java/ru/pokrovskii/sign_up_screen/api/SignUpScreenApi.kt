package ru.pokrovskii.sign_up_screen.api

import androidx.fragment.app.Fragment
import ru.pokrovskii.sign_up_screen.ui.SignUpScreenFragment

object SignUpScreenApi {

    fun createFragment(): Fragment {
        return SignUpScreenFragment.newInstance()
    }
}