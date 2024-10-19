package ru.pokrovskii.network.song.dto

import com.google.gson.annotations.SerializedName

internal data class StatsDto(
    @SerializedName("pageviews") val pageViewCount: Long,
    @SerializedName("hot") val isHot: Boolean,
)
