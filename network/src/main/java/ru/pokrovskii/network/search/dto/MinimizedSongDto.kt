package ru.pokrovskii.network.search.dto

import com.google.gson.annotations.SerializedName
import ru.pokrovskii.network.PrimaryArtistDto

internal data class MinimizedSongDto(
    @SerializedName("id") val id: Int,
    @SerializedName("song_art_image_thumbnail_url") val coverUrl: String?,
    @SerializedName("title") val title: String,
    @SerializedName("primary_artist") val artist: PrimaryArtistDto,
)
