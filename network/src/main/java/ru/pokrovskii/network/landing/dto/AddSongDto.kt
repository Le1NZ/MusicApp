package ru.pokrovskii.network.landing.dto

import com.google.gson.annotations.SerializedName

internal data class AddSongDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("artist") val artist: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("block_id") val blockId: String,
)
