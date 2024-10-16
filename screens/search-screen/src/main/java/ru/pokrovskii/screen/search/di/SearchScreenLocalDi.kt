package ru.pokrovskii.screen.search.di

import org.koin.dsl.module
import ru.pokrovskii.screen.search.domain.SearchScreenCenter

object SearchScreenLocalDi {

    val module = module {
        factory<SearchScreenCenter> { SearchScreenCenter(get()) }
    }
}