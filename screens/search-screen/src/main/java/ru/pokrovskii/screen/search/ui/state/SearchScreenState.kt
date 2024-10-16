package ru.pokrovskii.screen.search.ui.state

import androidx.compose.runtime.Immutable
import ru.pokrovskii.design.song.SongUiModel

@Immutable
internal sealed interface SearchScreenState {

    data object Loading : SearchScreenState
    data object Error : SearchScreenState

    data class Success(
        val results: List<SongUiModel>,
    ) : SearchScreenState
}
