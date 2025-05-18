package ru.pokrovskii.screen.artist.songs.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.model.SongItemUiModel

@Immutable
internal sealed interface ArtistSongsScreenState {

    data object Loading : ArtistSongsScreenState
    data object Error : ArtistSongsScreenState

    data class Success(
        val artistName: String,
        val songs: List<SongItem>,
    ) : ArtistSongsScreenState

    companion object {

        fun forPreview(): Success {
            return Success(
                artistName = "Markul",
                songs = List(5) { SongItem.forPreview() },
            )
        }
    }
}

@Immutable
internal data class SongItem(
    val model: MinimizedSong,
    val uiModel: SongItemUiModel,
) {

    companion object {

        fun forPreview(): SongItem {
            return SongItem(
                model = MinimizedSong.forPreview(),
                uiModel = SongItemUiModel.forPreview(),
            )
        }
    }
}