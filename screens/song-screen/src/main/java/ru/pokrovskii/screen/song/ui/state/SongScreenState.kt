package ru.pokrovskii.screen.song.ui.state

import androidx.compose.runtime.Immutable

@Immutable
internal interface SongScreenState {

    data object Loading : SongScreenState
    data object Error : SongScreenState

    data class Success(
        val songUiModel: SongUiModel,
    ) : SongScreenState

    companion object {

        fun forPreview(): SongScreenState {
            return Success(
                songUiModel = SongUiModel.PREVIEW,
            )
        }
    }
}