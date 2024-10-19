package ru.pokrovskii.screen.favorites.ui.state

import ru.pokrovskii.design.song.SongItemUiModel

internal sealed interface FavoritesScreenState {

    data object Loading : FavoritesScreenState

    data class Success(
        val songs: List<SongItemUiModel>,
    ) : FavoritesScreenState
}