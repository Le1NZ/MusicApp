package ru.pokrovskii.network.auth.dto

import com.google.gson.annotations.SerializedName

internal data class UserDto(
    @SerializedName("login") val login: String,
    @SerializedName("token") val token: String,
)
