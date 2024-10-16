package ru.pokrovskii.network.search.dto

import com.google.gson.annotations.SerializedName

internal data class HitDto(
    @SerializedName("result") val song: MinimizedSongDto,
)