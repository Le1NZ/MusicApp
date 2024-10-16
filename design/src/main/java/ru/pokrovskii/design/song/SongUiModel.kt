package ru.pokrovskii.design.song

data class SongUiModel(
    val id: Int,
    val coverUrl: String?,
    val title: String,
    val artist: String,
)
