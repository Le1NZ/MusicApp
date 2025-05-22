package ru.pokrovskii.implementation.sign_up

import org.koin.dsl.module
import ru.pokrovskii.sign_up_screen.api.SignUpScreenDependencies

object SignUpScreenDi {

    val module = module {
        single<SignUpScreenDependencies> { SignUpScreenDependenciesImpl(get()) }
    }
}