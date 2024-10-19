package ru.pokrovskii.network.song

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import ru.pokrovskii.network.BackendResponse
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.song.dto.ResponseSongDto

internal interface SongApi {

    @GET("songs/{id}")
    fun getSong(
        @Path("id") id: Int,
        @Header("Authorization") token: String = Config.TOKEN,
    ): Call<BackendResponse<ResponseSongDto>>
}