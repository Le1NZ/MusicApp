package ru.pokrovskii.database.api

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.model.song.MinimizedSong

interface FavoritesSongsLocalRepository {

    fun allSongsFlow(): Flow<List<MinimizedSong>>
    fun allSongs(): List<MinimizedSong>?
    suspend fun addSong(song: MinimizedSong)
    suspend fun deleteSong(song: MinimizedSong)
}