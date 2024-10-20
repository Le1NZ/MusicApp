package ru.pokrovskii.screen.song.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.song.api.SongRepository

internal class SongScreenCenter(
    private val songRepository: SongRepository,
    private val favoritesScreenLocalRepository: FavoritesSongsLocalRepository,
) {

    private var song: Song? = null

    suspend fun getSong(id: Int): Song? {
        return when (val result = songRepository.getSong(id)) {
            is DataOrError.Error -> null
            is DataOrError.Data -> {
                song = result.data
                song
            }
        }
    }

    suspend fun likeSong(song: Song) {
        favoritesScreenLocalRepository
            .addSong(song.toMinimizedSong())
    }

    suspend fun unlikeSong(song: Song) {
        favoritesScreenLocalRepository
            .deleteSong(song.toMinimizedSong())
    }

    fun isSongLiked(id: Int): Flow<Boolean> {
        return favoritesScreenLocalRepository
            .allSongs()
            .map {
                val currentSongInLiked = it.firstOrNull { song ->
                    song.id == id
                }
                currentSongInLiked != null
            }
    }

    fun getSongOrNull(): Song? {
        return song
    }
}