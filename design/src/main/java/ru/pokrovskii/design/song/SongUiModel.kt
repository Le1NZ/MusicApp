package ru.pokrovskii.design.song

import androidx.compose.runtime.Immutable

@Immutable
data class SongUiModel(
    val id: Int,
    val coverUrl: String?,
    val title: String,
    val artist: String,
)
