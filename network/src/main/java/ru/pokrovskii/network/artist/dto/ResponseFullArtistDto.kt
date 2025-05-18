package ru.pokrovskii.network.artist.dto

import com.google.gson.annotations.SerializedName

internal data class ResponseFullArtistDto(
    @SerializedName("artist") val artist: FullArtistDto,
)
