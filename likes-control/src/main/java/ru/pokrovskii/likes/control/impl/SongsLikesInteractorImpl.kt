package ru.pokrovskii.likes.control.impl

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.likes.control.api.SongsLikesInteractor
import ru.pokrovskii.model.song.MinimizedSong

internal class SongsLikesInteractorImpl(
    private val repository: FavoritesSongsLocalRepository,
) : SongsLikesInteractor {

    override fun allSongs(): Flow<List<MinimizedSong>> {
        return repository.allSongs()
    }
}