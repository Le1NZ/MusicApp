package ru.pokrovskii.network

import com.google.gson.annotations.SerializedName

internal data class ArtistDto(
    @SerializedName("id") val id: Int,
    @SerializedName("image_url") val coverUrl: String?,
    @SerializedName("name") val name: String,
)
