package ru.pokrovskii.design.di

import ru.pokrovskii.design.theme.AppThemeInteractorImpl
import ru.pokrovskii.design.theme.AppThemeStorage
import org.koin.dsl.module
import ru.pokrovskii.design.theme.api.AppThemeInteractor

object DesignDi {

    val module = module {
        single<AppThemeStorage> {
            AppThemeStorage(
                dataStoreProvider = get(),
            )
        }

        single<AppThemeInteractor> {
            AppThemeInteractorImpl(
                storage = get(),
            )
        }
    }
}