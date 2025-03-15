package ru.pokrovskii.screen.search.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.model.SongItemUiModel

@Immutable
internal sealed interface SearchScreenState {

    data object Loading : SearchScreenState
    data object Error : SearchScreenState

    sealed interface Success : SearchScreenState {

        data class Result(
            val results: List<SongItem>,
        ) : Success

        sealed interface History : Success {

            data object Empty : History

            data class Data(
                val history: List<SongItem>,
            ) : History
        }
    }

    companion object {

        fun forPreview(): SearchScreenState {
            return Success.Result(
                results = listOf(
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                    SongItem.forPreview(),
                )
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