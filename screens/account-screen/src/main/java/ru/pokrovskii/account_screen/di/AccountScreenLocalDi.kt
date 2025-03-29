package ru.pokrovskii.account_screen.di

import org.koin.dsl.module
import ru.pokrovskii.account_screen.domain.AccountScreenCenter

object AccountScreenLocalDi {

    val module = module {
        single<AccountScreenCenter> {
            AccountScreenCenter(
                appThemeInteractor = get(),
            )
        }
    }
}