package ru.pokrovskii.screen.favorites.di

import org.koin.dsl.module
import ru.pokrovskii.screen.favorites.domain.FavoritesScreenCenter

object FavoritesScreenLocalDi {

    val module = module {
        single<FavoritesScreenCenter> { FavoritesScreenCenter() }
    }
}