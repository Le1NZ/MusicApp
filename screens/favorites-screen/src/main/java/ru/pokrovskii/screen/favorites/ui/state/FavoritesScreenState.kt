package ru.pokrovskii.screen.favorites.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.model.SongItemUiModel

@Immutable
internal sealed interface FavoritesScreenState {

    data object Loading : FavoritesScreenState

    data class Success(
        val songs: List<SongItem>,
    ) : FavoritesScreenState

    companion object {

        fun forPreview(): FavoritesScreenState {
            return Success(
                songs = listOf(
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                )
            )
        }
    }
}

@Immutable
data class SongItem(
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