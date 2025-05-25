package ru.pokrovskii.network.landing.dto

import com.google.gson.annotations.SerializedName

internal data class LandingDto(
    @SerializedName("blocks") val blocks: List<LandingBlockDto>,
)

internal data class LandingBlockDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("songs") val songs: List<LandingSongDto>,
)

internal data class LandingSongDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("artist") val artist: String,
)