package ru.pokrovskii.screen.song.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.model.artist.Artist

@Immutable
data class SongUiModel(
    val title: String,
    val releaseDate: String,
    val pageViewCount: Long,
    val isHot: Boolean,
    val coverUrl: String?,
    val songTextUrl: String,
    val recordingLocation: String,
    val producers: List<Artist>,
    val artists: List<Artist>,
    val featuredArtists: List<Artist>,
)