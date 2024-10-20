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
}

@Immutable
data class SongItem(
    val model: MinimizedSong,
    val uiModel: SongItemUiModel,
)