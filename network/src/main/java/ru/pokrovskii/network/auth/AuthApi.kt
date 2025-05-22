package ru.pokrovskii.network.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.pokrovskii.network.auth.dto.LoginDto
import ru.pokrovskii.network.auth.dto.SignUpDto
import ru.pokrovskii.network.auth.dto.UserDto

internal interface AuthApi {

    @POST("login")
    fun login(
        @Body loginInfo: LoginDto,
    ): Call<UserDto>

    @POST("signup")
    fun signUp(
        @Body signUpInfo: SignUpDto,
    ): Call<UserDto>
}