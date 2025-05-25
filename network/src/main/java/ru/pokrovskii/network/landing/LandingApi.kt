package ru.pokrovskii.network.landing

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.pokrovskii.network.landing.dto.AddSongDto
import ru.pokrovskii.network.landing.dto.ChangeTitleDto
import ru.pokrovskii.network.landing.dto.DeleteSongDto
import ru.pokrovskii.network.landing.dto.LandingDto

internal interface LandingApi {

    @GET("landing/get")
    fun loadLanding(): Call<LandingDto>

    @POST("landing/changeTitle")
    fun changeBlockTitle(
        @Body title: ChangeTitleDto,
    ): Call<LandingDto>

    @POST("landing/deleteSong")
    fun deleteSong(
        @Body song: DeleteSongDto,
    ): Call<LandingDto>

    @POST("landing/addSong")
    fun addSong(
        @Body song: AddSongDto,
    ): Call<LandingDto>

    @POST("landing/addBlock")
    fun addBlock(): Call<LandingDto>
}