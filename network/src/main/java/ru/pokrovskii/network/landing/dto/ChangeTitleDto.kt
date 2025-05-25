package ru.pokrovskii.network.landing.dto

import com.google.gson.annotations.SerializedName

internal data class ChangeTitleDto(
    @SerializedName("title") val newTitle: String,
    @SerializedName("block_id") val blockId: String,
)
