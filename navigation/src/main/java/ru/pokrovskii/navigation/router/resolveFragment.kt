package ru.pokrovskii.navigation.router

import androidx.fragment.app.Fragment
import ru.pokrovskii.account_screen.api.AccountScreenApi
import ru.pokrovskii.log_in_screen.api.LoginScreenApi
import ru.pokrovskii.main_screen.api.MainScreenApi
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.screen.artist.api.ArtistScreenApi
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenApi
import ru.pokrovskii.screen.favorites.api.FavoritesScreenApi
import ru.pokrovskii.screen.search.api.SearchScreenApi
import ru.pokrovskii.screen.song.api.SongScreenApi
import ru.pokrovskii.sign_up_screen.api.SignUpScreenApi

internal fun Screen.resolveFragment(): Fragment {
    return when (this) {
        is Screen.Landing -> MainScreenApi.createFragment()

        is Screen.Song -> SongScreenApi.createFragment(
            SongScreenApi.Args(
                id = id,
            )
        )

        is Screen.Artist -> ArtistScreenApi.createFragment(
            args = ArtistScreenApi.Args(
                id = id,
            )
        )

        is Screen.ArtistSongs -> ArtistSongsScreenApi.createFragment(
            args = ArtistSongsScreenApi.Args(
                id = id,
                name = name,
            )
        )

        is Screen.Search -> SearchScreenApi.createFragment()
        is Screen.Favorites -> FavoritesScreenApi.createFragment()
        is Screen.Account -> AccountScreenApi.createFragment()

        is Screen.Login -> LoginScreenApi.createFragment()
        is Screen.SignUp -> SignUpScreenApi.createFragment()
    }
}