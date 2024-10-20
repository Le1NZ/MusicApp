package ru.pokrovskii.model.song

import ru.pokrovskii.model.artist.Artist

data class Song(
    val id: Int,
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
) {

    fun toMinimizedSong(): MinimizedSong {
        return MinimizedSong(
            id = id,
            title = title,
            coverUrl = coverUrl,
            artistName = artists.firstOrNull()?.name ?: "",
        )
    }
}
