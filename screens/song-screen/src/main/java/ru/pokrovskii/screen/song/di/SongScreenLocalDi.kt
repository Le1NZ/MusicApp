package ru.pokrovskii.screen.song.di

import org.koin.dsl.module
import ru.pokrovskii.screen.song.domain.SongScreenCenter

object SongScreenLocalDi {

    val module = module {
        factory<SongScreenCenter> { SongScreenCenter(get()) }
    }
}