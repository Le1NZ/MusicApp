package ru.pokrovskii.implementation.artist_songs

import org.koin.dsl.module
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenDependencies

internal object ArtistSongsScreenDi {

    val module = module {
        single<ArtistSongsScreenDependencies> { ArtistSongsScreenDependenciesImpl(get()) }
    }
}