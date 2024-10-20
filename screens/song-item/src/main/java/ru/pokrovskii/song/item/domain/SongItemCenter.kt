package ru.pokrovskii.song.item.domain

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.likes.control.api.EntityLikesInteractor
import ru.pokrovskii.model.song.MinimizedSong

internal class SongItemCenter(
    private val likesInteractor: EntityLikesInteractor,
) {

    suspend fun likeSong(song: MinimizedSong) {
        likesInteractor.likeSong(song)
    }

    suspend fun unlikeSong(song: MinimizedSong) {
        likesInteractor.unlikeSong(song)
    }

    fun isSongLikedFlow(id: Int): Flow<Boolean> {
        return likesInteractor.isSongLikedFlow(id)
    }

    fun isSongLiked(id: Int): Boolean {
        return likesInteractor.isSongLiked(id)
    }
}