package ru.pokrovskii.screen.artist.songs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenApi
import ru.pokrovskii.screen.artist.songs.domain.ArtistSongsScreenCenter
import ru.pokrovskii.screen.artist.songs.ui.state.ArtistSongsScreenState
import ru.pokrovskii.screen.artist.songs.ui.state.SongItem
import ru.pokrovskii.song.item.api.model.SongItemUiModelConverter

internal class ArtistSongsScreenViewModel(
    private val args: ArtistSongsScreenApi.Args,
    private val center: ArtistSongsScreenCenter,
) : ViewModel() {

    private var loadJob: Job? = null
    private val id get() = args.id

    private val _state = MutableStateFlow<ArtistSongsScreenState>(ArtistSongsScreenState.Loading)
    val state: StateFlow<ArtistSongsScreenState> = _state

    init {
        loadSongs()
    }

    fun onRetryClick() {
        _state.value = ArtistSongsScreenState.Loading
        loadSongs()
    }

    private fun loadSongs() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.getArtistSongs(id = id)
            _state.value = if (result == null) {
                ArtistSongsScreenState.Error
            } else {
                ArtistSongsScreenState.Success(
                    artistName = args.name,
                    songs = result.map { song ->
                        val minimizedSong = song.toMinimizedSong()
                        SongItem(
                            model = minimizedSong,
                            uiModel = SongItemUiModelConverter.convert(minimizedSong)
                        )
                    }
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