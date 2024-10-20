package ru.pokrovskii.screen.song.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.design.artist.ArtistItemUiModel

@Immutable
internal data class SongUiModel(
    val title: String,
    val releaseDate: String?,
    val pageViewCount: Long,
    val isHot: Boolean,
    val isLiked: Boolean,
    val coverUrl: String?,
    val songTextUrl: String,
    val recordingLocation: String?,
    val artists: List<ArtistItemUiModel>,
    val featuredArtists: List<ArtistItemUiModel>?,
    val producers: List<ArtistItemUiModel>?,
    val album: AlbumUiModel?,
) {

    companion object {

        val PREVIEW = SongUiModel(
            title = "Серпанитин",
            releaseDate = "Today",
            isHot = true,
            isLiked = false,
            pageViewCount = 100,
            coverUrl = null,
            songTextUrl = "",
            recordingLocation = "Moscow",
            producers = listOf(ArtistItemUiModel.PREVIEW),
            artists = listOf(ArtistItemUiModel.PREVIEW),
            featuredArtists = listOf(ArtistItemUiModel.PREVIEW),
            album = null,
        )
    }
}