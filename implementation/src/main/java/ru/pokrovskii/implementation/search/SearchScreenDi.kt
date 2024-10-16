package ru.pokrovskii.implementation.search

import org.koin.dsl.module
import ru.pokrovskii.screen.search.api.SearchScreenDependencies

internal object SearchScreenDi {

    val module = module {
        single<SearchScreenDependencies> { SearchScreenDependenciesImpl(get()) }
    }
}