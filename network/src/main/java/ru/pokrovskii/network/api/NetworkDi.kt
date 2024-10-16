package ru.pokrovskii.network.api

import org.koin.dsl.module
import ru.pokrovskii.network.search.api.SearchRepository
import ru.pokrovskii.network.search.impl.SearchRepositoryImpl

object NetworkDi {

    val module = module {
        single<SearchRepository> { SearchRepositoryImpl(get()) }
    }
}