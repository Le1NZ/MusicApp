package ru.pokrovskii.network.di

import org.koin.core.qualifier.named
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

    private const val GENIUS_RETROFIT = "GeniusRetrofit"
    private const val USER_RETROFIT = "UserRetrofit"

    val module = module {

        single<GeniusRetrofit>(named(GENIUS_RETROFIT)) {
            Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<UserRetrofit>(named(USER_RETROFIT)) {
            Retrofit
                .Builder()
                .baseUrl(UserServerConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single<SearchApi> { get<GeniusRetrofit>(named(GENIUS_RETROFIT)).create(SearchApi::class.java) }
        single<SongApi> { get<GeniusRetrofit>(named(GENIUS_RETROFIT)).create(SongApi::class.java) }
        single<ArtistApi> { get<GeniusRetrofit>(named(GENIUS_RETROFIT)).create(ArtistApi::class.java) }
        single<ArtistSongsApi> { get<GeniusRetrofit>(named(GENIUS_RETROFIT)).create(ArtistSongsApi::class.java) }

        single<AuthApi> { get<UserRetrofit>(named(USER_RETROFIT)).create(AuthApi::class.java) }
        single<LandingApi> { get<UserRetrofit>(named(USER_RETROFIT)).create(LandingApi::class.java) }
    }
}