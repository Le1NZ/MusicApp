package ru.pokrovskii.network.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.search.SearchApi

object NetworkLocalDi {

    val module = module {

        single<Retrofit> {
            Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        single<SearchApi> { get<Retrofit>().create(SearchApi::class.java) }
    }
}