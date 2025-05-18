package ru.pokrovskii.screen.artist.di

import org.koin.dsl.module
import ru.pokrovskii.screen.artist.domain.ArtistScreenCenter

object ArtistScreenLocalDi {

    val module = module {
        factory<ArtistScreenCenter> { ArtistScreenCenter(get()) }
    }
}