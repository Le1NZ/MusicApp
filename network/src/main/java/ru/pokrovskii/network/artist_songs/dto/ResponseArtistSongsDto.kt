package ru.pokrovskii.network.artist_songs.dto

import com.google.gson.annotations.SerializedName
import ru.pokrovskii.network.song.dto.SongDto

internal data class ResponseArtistSongsDto(
    @SerializedName("songs") val songs: List<SongDto>,
    @SerializedName("nextPage") val nextPage: Int,
)