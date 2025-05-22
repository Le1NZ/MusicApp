package ru.pokrovskii.network.auth.dto

import com.google.gson.annotations.SerializedName

internal data class SignUpDto(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
)
