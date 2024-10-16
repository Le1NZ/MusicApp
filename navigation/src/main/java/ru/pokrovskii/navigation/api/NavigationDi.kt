package ru.pokrovskii.navigation.api

import org.koin.dsl.module

object NavigationDi {

    val module = module {
        single<NavigationComponent> { NavigationComponent() }
    }
}