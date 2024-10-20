package ru.pokrovskii.screen.song.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
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
    private var collectLikeStatusJob: Job? = null
    private var setLikeStatusJob: Job? = null

    private val _state = MutableStateFlow<SongScreenState>(SongScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        loadSong()
    }

    fun onRetryClick() {
        loadSong()
    }

    fun onLikeClick() {
        setLikeStatusJob?.cancel()
        setLikeStatusJob = viewModelScope.launch {
            val song = songScreenCenter.getSongOrNull() ?: return@launch
            val isLiked = state.value.asSuccessOrNull()?.songUiModel?.isLiked ?: return@launch

            if (isLiked) {
                songScreenCenter.unlikeSong(song)
            } else {
                songScreenCenter.likeSong(song)
            }
        }
    }

    private fun loadSong() {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = songScreenCenter.getSong(args.id)
            if (result == null) {
                _state.value = SongScreenState.Error
            } else {
                collectLikeStatus(result.id)
                _state.value = SongScreenState.Success(
                    songUiModel = SongUiModelConverter.convert(
                        song = result,
                        isLiked = songScreenCenter.isSongLiked(result.id).first(),
                    )
                )
            }
        }
    }

    private fun collectLikeStatus(id: Int) {
        collectLikeStatusJob?.cancel()
        collectLikeStatusJob = viewModelScope.launch {
            songScreenCenter.isSongLiked(id).collect { isLiked ->
                updateLikeStatus(isLiked)
            }
        }
    }

    private fun updateLikeStatus(newLikeStatus: Boolean) {
        _state.update { currentState ->
            if (currentState is SongScreenState.Success) {
                SongScreenState.Success(
                    songUiModel = currentState.songUiModel.copy(isLiked = newLikeStatus),
                )
            } else {
                currentState
            }
        }
    }

    private fun SongScreenState.asSuccessOrNull() = (this as? SongScreenState.Success)

    override fun onCleared() {
        loadJob?.cancel()
        loadJob = null
        collectLikeStatusJob?.cancel()
        collectLikeStatusJob = null
        super.onCleared()
    }
}