package ru.pokrovskii.database.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_songs")
internal data class MinimizedSongDbo(
    @PrimaryKey val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("cover_url") val coverUrl: String?,
    @ColumnInfo("artist_name") val artistName: String,
    @ColumnInfo("timestamp") val timestamp: Long = System.currentTimeMillis(),
)
