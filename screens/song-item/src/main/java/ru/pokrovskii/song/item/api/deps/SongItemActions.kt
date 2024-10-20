package ru.pokrovskii.song.item.api.deps

import androidx.compose.runtime.Immutable

@Immutable
interface SongItemActions {

    fun onSongItemClick(id: Int)
}