package ru.pokrovskii.song.item.di

import org.koin.dsl.module
import ru.pokrovskii.song.item.domain.SongItemCenter

object SongItemLocalDi {

    val module = module {
        single<SongItemCenter> { SongItemCenter(get()) }
    }
}