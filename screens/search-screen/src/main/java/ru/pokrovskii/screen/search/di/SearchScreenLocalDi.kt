package ru.pokrovskii.screen.search.di

import org.koin.dsl.module
import ru.pokrovskii.screen.search.domain.SearchScreenCenter
import ru.pokrovskii.screen.search.history.HistoryStorage

object SearchScreenLocalDi {

    val module = module {
        single<HistoryStorage> {
            HistoryStorage(
                dataStoreProvider = get(),
            )
        }

        factory<SearchScreenCenter> {
            SearchScreenCenter(
                repository = get(),
                storage = get(),
            )
        }
    }
}