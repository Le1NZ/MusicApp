package ru.pokrovskii.network.search

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import ru.pokrovskii.network.BackendResponse
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.search.dto.HitsDto

internal interface SearchApi {

    @GET("search/")
    fun getSearchResult(
        @Query("q") query: String,
        @Header("Authorization") token: String = Config.TOKEN,
    ): Call<BackendResponse<HitsDto>>
}