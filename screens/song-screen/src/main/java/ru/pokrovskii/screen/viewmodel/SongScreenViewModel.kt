package ru.pokrovskii.screen.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.pokrovskii.screen.song.api.SongScreenApi
import ru.pokrovskii.screen.song.ui.state.SongScreenState

internal class SongScreenViewModel(
    private val args: SongScreenApi.Args,
) : ViewModel() {

    private val _state = MutableStateFlow<SongScreenState>(SongScreenState.Loading)
    val state = _state.asStateFlow()

    fun onRetryClick() {

    }
}