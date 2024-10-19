package ru.pokrovskii.implementation.favorites

import org.koin.dsl.module
import ru.pokrovskii.screen.favorites.api.FavoritesScreenDependencies

internal object FavoritesScreenDi {

    val module = module {
        single<FavoritesScreenDependencies> { FavoritesScreenDependenciesImpl(get()) }
    }
}