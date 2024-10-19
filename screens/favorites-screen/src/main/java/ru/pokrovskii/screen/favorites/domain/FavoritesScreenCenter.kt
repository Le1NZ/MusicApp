package ru.pokrovskii.screen.favorites.domain

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.model.song.MinimizedSong

internal class FavoritesScreenCenter(
    private val favoritesSongsLocalRepository: FavoritesSongsLocalRepository,
) {

    fun allSongs(): Flow<List<MinimizedSong>> {
        return favoritesSongsLocalRepository.allSongs()
    }
}