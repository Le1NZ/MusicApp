package ru.pokrovskii.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.pokrovskii.database.dao.FavoritesSongsDao
import ru.pokrovskii.database.dbo.MinimizedSongDbo

@Database(
    entities = [MinimizedSongDbo::class],
    version = 1,
    exportSchema = false,
)
internal abstract class FavoriteSongsDb : RoomDatabase() {

    abstract fun dao(): FavoritesSongsDao
}