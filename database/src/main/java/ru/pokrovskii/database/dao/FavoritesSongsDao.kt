package ru.pokrovskii.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.database.dbo.MinimizedSongDbo

@Dao
internal interface FavoritesSongsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(song: MinimizedSongDbo)

    @Delete
    suspend fun deleteSong(song: MinimizedSongDbo)

    @Query("SELECT * FROM favorite_songs ORDER BY timestamp DESC")
    fun getAll(): Flow<List<MinimizedSongDbo>>
}