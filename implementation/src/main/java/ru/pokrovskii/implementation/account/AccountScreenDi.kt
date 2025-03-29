package ru.pokrovskii.implementation.account

import org.koin.dsl.module
import ru.pokrovskii.account_screen.api.AccountScreenDependencies

internal object AccountScreenDi {

    val module = module {
        single<AccountScreenDependencies> {
            AccountScreenDependenciesImpl(
                navigationComponent = get(),
            )
        }
    }
}