package ru.pokrovskii.screen.search.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.pokrovskii.screen.search.domain.SearchScreenCenter
import ru.pokrovskii.screen.search.viewmodel.SearchScreenViewModel

object SearchScreenLocalDi {

    val module = module {
        factory<SearchScreenCenter> { SearchScreenCenter(get()) }
        viewModel { SearchScreenViewModel(get()) }
    }
}