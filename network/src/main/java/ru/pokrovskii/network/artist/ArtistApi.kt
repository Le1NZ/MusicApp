package ru.pokrovskii.network.artist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import ru.pokrovskii.network.BackendResponse
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.artist.dto.ResponseFullArtistDto

internal interface ArtistApi {

    @GET("artists/{id}")
    fun getArtist(
        @Path("id") id: String,
        @Header("Authorization") token: String = Config.TOKEN,
    ): Call<BackendResponse<ResponseFullArtistDto>>
}