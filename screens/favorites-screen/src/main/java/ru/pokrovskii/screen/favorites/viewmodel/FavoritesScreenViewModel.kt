package ru.pokrovskii.screen.favorites.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.pokrovskii.screen.favorites.domain.FavoritesScreenCenter
import ru.pokrovskii.screen.favorites.ui.state.FavoritesScreenState

internal class FavoritesScreenViewModel(
    private val favoritesScreenCenter: FavoritesScreenCenter,
) : ViewModel() {

    private val _state = MutableStateFlow<FavoritesScreenState>(FavoritesScreenState.Loading)
    val state = _state.asStateFlow()


}