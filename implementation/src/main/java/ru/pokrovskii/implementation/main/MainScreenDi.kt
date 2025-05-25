package ru.pokrovskii.implementation.main

import org.koin.dsl.module
import ru.pokrovskii.main_screen.api.MainScreenDependencies

internal object MainScreenDi {

    val module = module {
        single<MainScreenDependencies> { MainScreenDependenciesImpl(get()) }
    }
}