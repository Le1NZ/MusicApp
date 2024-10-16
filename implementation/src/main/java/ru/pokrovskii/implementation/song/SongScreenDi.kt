package ru.pokrovskii.implementation.song

import org.koin.dsl.module
import ru.pokrovskii.screen.song.api.SongScreenDependencies

object SongScreenDi {

    val module = module {
        single<SongScreenDependencies> { SongScreenDependenciesImpl(get()) }
    }
}