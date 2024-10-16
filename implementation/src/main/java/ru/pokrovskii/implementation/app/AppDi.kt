package ru.pokrovskii.implementation.app

import ru.pokrovskii.implementation.search.SearchScreenDi
import ru.pokrovskii.implementation.song.SongScreenDi
import ru.pokrovskii.navigation.api.NavigationDi
import ru.pokrovskii.network.api.NetworkDi
import ru.pokrovskii.network.di.NetworkLocalDi
import ru.pokrovskii.screen.search.di.SearchScreenLocalDi
import ru.pokrovskii.screen.song.di.SongScreenLocalDi

internal object AppDi {

    val modules = listOf(
        NavigationDi.module,
        SearchScreenDi.module,
        NetworkLocalDi.module,
        NetworkDi.module,
        SearchScreenLocalDi.module,
        SongScreenDi.module,
        SongScreenLocalDi.module,
    )
}