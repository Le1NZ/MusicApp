package ru.pokrovskii.implementation.auth

import org.koin.dsl.module
import ru.pokrovskii.log_in_screen.api.LoginScreenDependencies

internal object LoginScreenDi {

    val module = module {
        single<LoginScreenDependencies> { LoginScreenDependenciesImpl(get()) }
    }
}