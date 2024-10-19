package ru.pokrovskii.model.song

data class MinimizedSong(
    val id: Int,
    val title: String,
    val coverUrl: String?,
    val artistName: String,
)