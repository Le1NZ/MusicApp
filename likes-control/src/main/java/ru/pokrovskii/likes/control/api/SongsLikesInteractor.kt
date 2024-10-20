package ru.pokrovskii.likes.control.api

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.model.song.MinimizedSong

interface SongsLikesInteractor {

    fun allSongs(): Flow<List<MinimizedSong>>
}