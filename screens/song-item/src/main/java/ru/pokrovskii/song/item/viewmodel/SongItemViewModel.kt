package ru.pokrovskii.song.item.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.domain.SongItemCenter

internal class SongItemViewModel(
    private val center: SongItemCenter,
) : ViewModel() {

    private var likeJob: Job? = null

    fun isLiked(id: Int): StateFlow<Boolean> {
        return center
            .isSongLikedFlow(id)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = center.isSongLiked(id),
            )
    }

    fun onLikeClick(song: MinimizedSong, isLiked: Boolean) {
        likeJob?.cancel()
        likeJob = viewModelScope.launch {
            if (isLiked) {
                center.unlikeSong(song)
            } else {
                center.likeSong(song)
            }
        }
    }

    override fun onCleared() {
        likeJob?.cancel()
        likeJob = null
        super.onCleared()
    }
}