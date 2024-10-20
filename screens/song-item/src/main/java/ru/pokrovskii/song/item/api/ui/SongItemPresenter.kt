package ru.pokrovskii.song.item.api.ui

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Stable
interface SongItemPresenter {

    val isLiked: StateFlow<Boolean>

    fun onClick()
    fun onLikeClick()
}

class SongItemPresenterPreview : SongItemPresenter {

    override val isLiked = MutableStateFlow(false)

    override fun onClick() = Unit
    override fun onLikeClick() = Unit
}