package ru.pokrovskii.network.song.api

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song

interface SongRepository {

    suspend fun getSong(id: Int): DataOrError<Song>
}