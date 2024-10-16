package ru.pokrovskii.screen.search.ui.state

import ru.pokrovskii.design.song.SongUiModel

internal sealed interface SearchScreenState {

    data object Loading : SearchScreenState
    data object Error : SearchScreenState

    data class Success(
        val results: List<SongUiModel>,
    ) : SearchScreenState
}
