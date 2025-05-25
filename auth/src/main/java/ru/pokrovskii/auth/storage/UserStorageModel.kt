package ru.pokrovskii.auth.storage

import com.google.gson.annotations.SerializedName

internal data class UserStorageModel(
    @SerializedName("login") val login: String,
    @SerializedName("token") val token: String,
    @SerializedName("admin") val isAdmin: Boolean,
)