package ru.pokrovskii.implementation.app

import ru.pokrovskii.database.api.DatabaseDi
import ru.pokrovskii.database.di.DatabaseLocalDi
import ru.pokrovskii.implementation.favorites.FavoritesScreenDi
import ru.pokrovskii.implementation.search.SearchScreenDi
import ru.pokrovskii.implementation.song.SongScreenDi
import ru.pokrovskii.likes.control.api.LikesControlDi
import ru.pokrovskii.navigation.api.NavigationDi
import ru.pokrovskii.network.api.NetworkDi
import ru.pokrovskii.network.di.NetworkLocalDi
import ru.pokrovskii.screen.favorites.di.FavoritesScreenLocalDi
import ru.pokrovskii.screen.search.di.SearchScreenLocalDi
import ru.pokrovskii.screen.song.di.SongScreenLocalDi
import ru.pokrovskii.song.item.di.SongItemLocalDi

internal object AppDi {

    val modules = listOf(
        NavigationDi.module,
        SearchScreenDi.module,
        NetworkLocalDi.module,
        NetworkDi.module,
        DatabaseDi.module,
        DatabaseLocalDi.module,
        LikesControlDi.module,
        SongItemLocalDi.module,
        SearchScreenLocalDi.module,
        SongScreenDi.module,
        SongScreenLocalDi.module,
        FavoritesScreenDi.module,
        FavoritesScreenLocalDi.module,
    )
}