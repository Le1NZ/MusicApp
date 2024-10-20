package ru.pokrovskii.implementation.song_item

import org.koin.dsl.module
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.deps.SongItemDependencies

object SongItemDi {

    val module = module {
        factory<SongItemDependencies> { SongItemDependenciesImpl(get()) }
        factory<SongItemComponent> { SongItemComponent(get()) }
    }
}