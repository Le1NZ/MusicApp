package ru.pokrovskii.screen.song.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.screen.song.api.SongScreenApi
import ru.pokrovskii.screen.song.domain.SongScreenCenter
import ru.pokrovskii.screen.song.ui.mapper.SongUiModelConverter
import ru.pokrovskii.screen.song.ui.state.SongScreenState

internal class SongScreenViewModel(
    private val songScreenCenter: SongScreenCenter,
    private val args: SongScreenApi.Args,
) : ViewModel() {

    private var loadJob: Job? = null

    private val _state = MutableStateFlow<SongScreenState>(SongScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        loadSong()
    }

    fun onRetryClick() {
        loadSong()
    }

    private fun loadSong() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = songScreenCenter.getSong(args.id)
            if (result == null) {
                _state.value = SongScreenState.Error
            } else {
                _state.value = SongScreenState.Success(
                    songUiModel = SongUiModelConverter.convert(result)
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