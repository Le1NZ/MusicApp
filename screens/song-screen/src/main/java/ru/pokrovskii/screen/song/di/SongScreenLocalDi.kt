package ru.pokrovskii.screen.song.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.pokrovskii.screen.song.domain.SongScreenCenter
import ru.pokrovskii.screen.viewmodel.SongScreenViewModel

object SongScreenLocalDi {

    val module = module {
        factory<SongScreenCenter> { SongScreenCenter() }
        viewModel { SongScreenViewModel(get()) }
    }
}