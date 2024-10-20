package ru.pokrovskii.screen.song.domain

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.likes.control.api.EntityLikesInteractor
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.song.api.SongRepository

internal class SongScreenCenter(
    private val songRepository: SongRepository,
    private val likesInteractor: EntityLikesInteractor,
) {

    private var song: Song? = null

    suspend fun loadSong(id: Int): Song? {
        return when (val result = songRepository.getSong(id)) {
            is DataOrError.Error -> null
            is DataOrError.Data -> {
                song = result.data
                song
            }
        }
    }

    suspend fun likeSong(song: Song) {
        likesInteractor
            .likeSong(song.toMinimizedSong())
    }

    suspend fun unlikeSong(song: Song) {
        likesInteractor
            .unlikeSong(song.toMinimizedSong())
    }

    fun isSongLiked(id: Int): Flow<Boolean> {
        return likesInteractor
            .isSongLikedFlow(id)
    }

    fun getSongOrNull(): Song? {
        return song
    }
}