package ru.pokrovskii.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.database.dbo.MinimizedSongDbo

@Dao
internal interface FavoritesSongsDao {

    @Insert
    suspend fun insertSong(song: MinimizedSongDbo)

    @Delete
    suspend fun deleteSong(song: MinimizedSongDbo)

    @Query("SELECT * FROM favorite_songs")
    fun getAll(): Flow<List<MinimizedSongDbo>>
}