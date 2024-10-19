package ru.pokrovskii.model.song

import ru.pokrovskii.model.artist.Artist

data class Song(
    val title: String,
    val releaseDate: String?,
    val pageViewCount: Long,
    val isHot: Boolean,
    val coverUrl: String?,
    val songTextUrl: String,
    val recordingLocation: String?,
    val artists: List<Artist>,
    val producers: List<Artist>?,
    val featuredArtists: List<Artist>?,
)
