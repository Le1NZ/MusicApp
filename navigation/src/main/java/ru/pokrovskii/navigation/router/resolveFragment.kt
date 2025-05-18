package ru.pokrovskii.navigation.router

import androidx.fragment.app.Fragment
import ru.pokrovskii.account_screen.api.AccountScreenApi
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.screen.artist.api.ArtistScreenApi
import ru.pokrovskii.screen.favorites.api.FavoritesScreenApi
import ru.pokrovskii.screen.search.api.SearchScreenApi
import ru.pokrovskii.screen.song.api.SongScreenApi

internal fun Screen.resolveFragment(): Fragment {
    return when (this) {
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

        is Screen.Search -> SearchScreenApi.createFragment()
        is Screen.Favorites -> FavoritesScreenApi.createFragment()
        is Screen.Account -> AccountScreenApi.createFragment()
    }
}