package ru.pokrovskii.network.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.UserServerConfig
import ru.pokrovskii.network.artist.ArtistApi
import ru.pokrovskii.network.artist_songs.ArtistSongsApi
import ru.pokrovskii.network.auth.AuthApi
import ru.pokrovskii.network.landing.LandingApi
import ru.pokrovskii.network.search.SearchApi
import ru.pokrovskii.network.song.SongApi

private typealias GeniusRetrofit = Retrofit
private typealias UserRetrofit = Retrofit

object NetworkLocalDi {

    val module = module {

        single<GeniusRetrofit> {
            Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<UserRetrofit> {
            Retrofit
                .Builder()
                .baseUrl(UserServerConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<SearchApi> { get<GeniusRetrofit>().create(SearchApi::class.java) }
        single<SongApi> { get<GeniusRetrofit>().create(SongApi::class.java) }
        single<ArtistApi> { get<GeniusRetrofit>().create(ArtistApi::class.java) }
        single<ArtistSongsApi> { get<GeniusRetrofit>().create(ArtistSongsApi::class.java) }

        single<AuthApi> { get<UserRetrofit>().create(AuthApi::class.java) }
        single<LandingApi> { get<UserRetrofit>().create(LandingApi::class.java) }
    }
}