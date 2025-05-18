package ru.pokrovskii.network.artist_songs

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import ru.pokrovskii.network.BackendResponse
import ru.pokrovskii.network.Config
import ru.pokrovskii.network.artist_songs.dto.ResponseArtistSongsDto

internal interface ArtistSongsApi {

    @GET("artists/{id}/songs")
    fun getArtistSongs(
        @Path("id") id: String,
        @Query("sort") sortType: String,
        @Query("per_page") countPerPage: Int,
        @Query("page") pageNumber: Int,
        @Header("Authorization") token: String = Config.TOKEN,
    ): Call<BackendResponse<ResponseArtistSongsDto>>
}