package ru.pokrovskii.song.item.api.model

import androidx.compose.runtime.Immutable

@Immutable
data class SongItemUiModel(
    val id: Int,
    val coverUrl: String?,
    val title: String,
    val artist: String,
)
