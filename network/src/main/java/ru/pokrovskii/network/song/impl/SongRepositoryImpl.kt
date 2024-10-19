package ru.pokrovskii.network.song.impl

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.mappers.toSong
import ru.pokrovskii.network.song.SongApi
import ru.pokrovskii.network.song.api.SongRepository
import ru.pokrovskii.network.utils.toResult

internal class SongRepositoryImpl(
    private val songApi: SongApi,
) : SongRepository {

    override suspend fun getSong(id: Int): DataOrError<Song> {
        return songApi
            .getSong(id)
            .toResult {
                song.toSong()
            }
    }
}