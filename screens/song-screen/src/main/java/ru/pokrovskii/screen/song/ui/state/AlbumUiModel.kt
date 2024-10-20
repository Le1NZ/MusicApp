package ru.pokrovskii.screen.song.ui.state

import androidx.compose.runtime.Immutable

@Immutable
data class AlbumUiModel(
    val name: String,
    val artistNames: String,
    val coverUrl: String?,
)
