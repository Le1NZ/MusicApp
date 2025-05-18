package ru.pokrovskii.implementation.app

import ru.pokrovskii.account_screen.di.AccountScreenLocalDi
import ru.pokrovskii.database.di.DatabaseDi
import ru.pokrovskii.design.di.DesignDi
import ru.pokrovskii.implementation.account.AccountScreenDi
import ru.pokrovskii.implementation.artist.ArtistScreenDi
import ru.pokrovskii.implementation.favorites.FavoritesScreenDi
import ru.pokrovskii.implementation.search.SearchScreenDi
import ru.pokrovskii.implementation.song.SongScreenDi
import ru.pokrovskii.likes.control.api.LikesControlDi
import ru.pokrovskii.navigation.api.NavigationDi
import ru.pokrovskii.network.api.NetworkDi
import ru.pokrovskii.network.di.NetworkLocalDi
import ru.pokrovskii.screen.artist.di.ArtistScreenLocalDi
import ru.pokrovskii.screen.favorites.di.FavoritesScreenLocalDi
import ru.pokrovskii.screen.search.di.SearchScreenLocalDi
import ru.pokrovskii.screen.song.di.SongScreenLocalDi
import ru.pokrovskii.song.item.di.SongItemLocalDi
import ru.pokrovskii.storage.di.StorageDi

internal object AppDi {

    val modules = listOf(
        DesignDi.module,
        NavigationDi.module,
        SearchScreenDi.module,
        NetworkLocalDi.module,
        NetworkDi.module,
        DatabaseDi.module,
        StorageDi.module,
        LikesControlDi.module,
        SongItemLocalDi.module,
        SearchScreenLocalDi.module,
        SongScreenDi.module,
        SongScreenLocalDi.module,
        FavoritesScreenDi.module,
        FavoritesScreenLocalDi.module,
        AccountScreenDi.module,
        AccountScreenLocalDi.module,
        ArtistScreenDi.module,
        ArtistScreenLocalDi.module,
    )
}