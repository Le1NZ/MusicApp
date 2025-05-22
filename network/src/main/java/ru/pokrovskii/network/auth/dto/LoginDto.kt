package ru.pokrovskii.network.auth.dto

import com.google.gson.annotations.SerializedName

internal data class LoginDto(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
)
