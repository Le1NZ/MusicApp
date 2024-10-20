package ru.pokrovskii.screen.favorites.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.pokrovskii.screen.favorites.domain.FavoritesScreenCenter
import ru.pokrovskii.screen.favorites.ui.mapper.SongItemConverter
import ru.pokrovskii.screen.favorites.ui.state.FavoritesScreenState

internal class FavoritesScreenViewModel(
    favoritesScreenCenter: FavoritesScreenCenter,
) : ViewModel() {

    private val favoritesSongs = favoritesScreenCenter
        .allSongs()
        .map { it.map(SongItemConverter::convert) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = null,
        )

    val state = favoritesSongs
        .map {
            if (it == null) return@map FavoritesScreenState.Loading
            FavoritesScreenState.Success(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = FavoritesScreenState.Loading,
        )

}