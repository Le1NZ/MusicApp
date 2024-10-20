package ru.pokrovskii.likes.control.api

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.model.song.MinimizedSong

interface EntityLikesInteractor {

    suspend fun likeSong(song: MinimizedSong)
    suspend fun unlikeSong(song: MinimizedSong)
    fun isSongLiked(id: Int): Flow<Boolean>
}