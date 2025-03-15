package ru.pokrovskii.storage.di

import org.koin.dsl.module
import ru.pokrovskii.storage.api.DataStoreProvider
import ru.pokrovskii.storage.provider.DataStoreProviderImpl

object StorageDi {

    val module = module {
        factory<DataStoreProvider> { DataStoreProviderImpl(get()) }
    }
}