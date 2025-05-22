package ru.pokrovskii.sign_up_screen.di

import org.koin.dsl.module
import ru.pokrovskii.sign_up_screen.domain.SignUpScreenCenter

object SignUpScreenLocalDi {

    val module = module {
        single<SignUpScreenCenter> { SignUpScreenCenter(get()) }
    }
}