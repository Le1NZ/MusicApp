package ru.pokrovskii.implementation.artist

import org.koin.dsl.module
import ru.pokrovskii.screen.artist.api.ArtistScreenDependencies

internal object ArtistScreenDi {

    val module = module {
        single<ArtistScreenDependencies> { ArtistScreenDependenciesImpl(get()) }
    }
}