package ru.pokrovskii.network

import com.google.gson.annotations.SerializedName

internal data class BackendResponse<T>(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("response") val response: T
)

internal data class Meta(
    @SerializedName("status") val statusCode: Int,
)