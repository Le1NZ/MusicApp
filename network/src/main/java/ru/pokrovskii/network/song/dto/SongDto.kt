package ru.pokrovskii.network.song.dto

import com.google.gson.annotations.SerializedName
import ru.pokrovskii.network.AlbumDto
import ru.pokrovskii.network.ArtistDto

internal data class SongDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("header_image_url") val coverUrl: String?,
    @SerializedName("stats") val stats: StatsDto,
    @SerializedName("album") val album: AlbumDto?,
    @SerializedName("release_date_for_display") val releaseDate: String?,
    @SerializedName("recording_location") val recordingLocation: String?,
    @SerializedName("url") val textUrl: String,
    @SerializedName("primary_artists") val primaryArtists: List<ArtistDto>,
    @SerializedName("featured_artists") val featuredArtists: List<ArtistDto>?,
    @SerializedName("producer_artists") val producerArtists: List<ArtistDto>?,
)
