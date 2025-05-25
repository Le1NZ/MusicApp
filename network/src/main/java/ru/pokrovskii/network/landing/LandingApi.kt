package ru.pokrovskii.network.landing

import retrofit2.Call
import retrofit2.http.GET
import ru.pokrovskii.network.landing.dto.LandingDto

internal interface LandingApi {

    @GET("landing")
    fun loadLanding(): Call<LandingDto>
}