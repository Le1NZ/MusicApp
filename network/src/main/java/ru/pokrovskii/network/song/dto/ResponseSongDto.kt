package ru.pokrovskii.network.song.dto

import com.google.gson.annotations.SerializedName

internal data class ResponseSongDto(
    @SerializedName("song") val song: SongDto,
)
