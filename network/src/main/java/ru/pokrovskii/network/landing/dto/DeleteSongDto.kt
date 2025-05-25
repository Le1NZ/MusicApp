package ru.pokrovskii.network.landing.dto

import com.google.gson.annotations.SerializedName

internal data class DeleteSongDto(
    @SerializedName("block_id") val blockId: String,
    @SerializedName("id") val id: Int,
)
