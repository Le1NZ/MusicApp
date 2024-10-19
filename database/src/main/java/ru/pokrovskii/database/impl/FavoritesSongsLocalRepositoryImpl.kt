package ru.pokrovskii.database.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.database.dao.FavoritesSongsDao
import ru.pokrovskii.database.dbo.mapper.MinimizedSongConverter
import ru.pokrovskii.model.song.MinimizedSong

internal class FavoritesSongsLocalRepositoryImpl(
    private val dao: FavoritesSongsDao,
) : FavoritesSongsLocalRepository {

    override fun allSongs(): Flow<List<MinimizedSong>> {
        return dao.getAll().map { it.map(MinimizedSongConverter::convert) }
    }

    override suspend fun addSong(song: MinimizedSong) {
        return withContext(Dispatchers.IO) {
            dao.insertSong(MinimizedSongConverter.convert(song))
        }
    }

    override suspend fun deleteSong(song: MinimizedSong) {
        return withContext(Dispatchers.IO) {
            dao.deleteSong(MinimizedSongConverter.convert(song))
        }
    }
}