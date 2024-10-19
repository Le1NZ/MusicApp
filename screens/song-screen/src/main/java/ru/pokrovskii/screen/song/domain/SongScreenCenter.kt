package ru.pokrovskii.screen.song.domain

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.song.api.SongRepository

internal class SongScreenCenter(
    private val songRepository: SongRepository,
) {

    suspend fun getSong(id: Int): Song? {
        return when (val result = songRepository.getSong(id)) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }
}