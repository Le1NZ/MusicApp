package ru.pokrovskii.screen.artist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.screen.artist.api.ArtistScreenApi
import ru.pokrovskii.screen.artist.domain.ArtistScreenCenter
import ru.pokrovskii.screen.artist.ui.converter.toFullArtistUiModel
import ru.pokrovskii.screen.artist.ui.state.ArtistScreenState

internal class ArtistScreenViewModel(
    private val args: ArtistScreenApi.Args,
    private val center: ArtistScreenCenter,
) : ViewModel() {

    private var loadJob: Job? = null

    private val _state = MutableStateFlow<ArtistScreenState>(ArtistScreenState.Loading)
    val state: StateFlow<ArtistScreenState> = _state

    val id get() = args.id

    init {
        loadArtist()
    }

    fun onRetryClick() {
        _state.value = ArtistScreenState.Loading
        loadArtist()
    }

    private fun loadArtist() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.getArtist(id = id)
            _state.value = if (result == null) {
                ArtistScreenState.Error
            } else {
                ArtistScreenState.Success(
                    artist = result.toFullArtistUiModel(),
                )
            }
        }
    }

    override fun onCleared() {
        loadJob?.cancel()
        loadJob = null
        super.onCleared()
    }
}