package ru.pokrovskii.log_in_screen.di

import org.koin.dsl.module
import ru.pokrovskii.log_in_screen.domain.LoginScreenCenter

object LoginScreenLocalDi {

    val module = module {
        single<LoginScreenCenter> { LoginScreenCenter(get()) }
    }
}
