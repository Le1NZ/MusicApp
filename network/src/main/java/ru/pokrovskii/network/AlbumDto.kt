package ru.pokrovskii.network

import com.google.gson.annotations.SerializedName

internal data class AlbumDto(
    @SerializedName("name") val name: String,
    @SerializedName("cover_art_url") val coverUrl: String?,
    @SerializedName("primary_artist_names") val artistNames: String,
)
