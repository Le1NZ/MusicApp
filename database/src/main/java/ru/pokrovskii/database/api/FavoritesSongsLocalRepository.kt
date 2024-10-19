package ru.pokrovskii.database.api

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.model.song.MinimizedSong

interface FavoritesSongsLocalRepository {

    fun allSongs(): Flow<List<MinimizedSong>>
    suspend fun addSong(song: MinimizedSong)
    suspend fun deleteSong(song: MinimizedSong)
}