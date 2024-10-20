package ru.pokrovskii.screen.favorites.domain

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.likes.control.api.SongsLikesInteractor
import ru.pokrovskii.model.song.MinimizedSong

internal class FavoritesScreenCenter(
    private val songsLikesInteractor: SongsLikesInteractor,
) {

    fun allSongs(): Flow<List<MinimizedSong>> {
        return songsLikesInteractor.allSongs()
    }
}