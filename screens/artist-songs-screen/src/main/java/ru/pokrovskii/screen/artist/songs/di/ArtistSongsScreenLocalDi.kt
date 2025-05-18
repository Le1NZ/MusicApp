package ru.pokrovskii.screen.artist.songs.di

import org.koin.dsl.module
import ru.pokrovskii.screen.artist.songs.domain.ArtistSongsScreenCenter

object ArtistSongsScreenLocalDi {

    val module = module {
        factory<ArtistSongsScreenCenter> { ArtistSongsScreenCenter(get()) }
    }
}