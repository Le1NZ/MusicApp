package ru.pokrovskii.network.api

import org.koin.dsl.module
import ru.pokrovskii.network.artist.api.ArtistRepository
import ru.pokrovskii.network.artist.impl.ArtistRepositoryImpl
import ru.pokrovskii.network.artist_songs.api.ArtistSongsRepository
import ru.pokrovskii.network.artist_songs.impl.ArtistSongsRepositoryImpl
import ru.pokrovskii.network.search.api.SearchRepository
import ru.pokrovskii.network.search.impl.SearchRepositoryImpl
import ru.pokrovskii.network.song.api.SongRepository
import ru.pokrovskii.network.song.impl.SongRepositoryImpl

object NetworkDi {

    val module = module {
        single<SearchRepository> { SearchRepositoryImpl(get()) }
        single<SongRepository> { SongRepositoryImpl(get()) }
        single<ArtistRepository> { ArtistRepositoryImpl(get()) }
        single<ArtistSongsRepository> { ArtistSongsRepositoryImpl(get()) }
    }
}