package ru.pokrovskii.likes.control.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.likes.control.api.EntityLikesInteractor
import ru.pokrovskii.model.song.MinimizedSong

internal class EntityLikesInteractorImpl(
    private val repository: FavoritesSongsLocalRepository,
) : EntityLikesInteractor {

    override suspend fun likeSong(song: MinimizedSong) {
        repository
            .addSong(song)
    }

    override suspend fun unlikeSong(song: MinimizedSong) {
        repository
            .deleteSong(song)
    }

    override fun isSongLiked(id: Int): Flow<Boolean> {
        return repository
            .allSongs()
            .map {
                val currentSongInLiked = it.firstOrNull { song ->
                    song.id == id
                }
                currentSongInLiked != null
            }
    }
}