package ru.pokrovskii.model.song

import ru.pokrovskii.model.artist.PrimaryArtist

data class MinimizedSong(
    val id: Int,
    val title: String,
    val coverUrl: String?,
    val artist: PrimaryArtist,
)