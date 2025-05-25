package ru.pokrovskii.main_screen.di

import org.koin.dsl.module
import ru.pokrovskii.main_screen.domain.MainScreenCenter

object MainScreenLocalDi {

    val module = module {
        single<MainScreenCenter> { MainScreenCenter(inject()) }
    }
}