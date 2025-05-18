package ru.pokrovskii.network.artist_songs.api

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song

interface ArtistSongsRepository {

    suspend fun getArtistSongs(
        id: String,
        sortType: ArtistSongsSortType,
        countPerPage: Int,
        pageNumber: Int,
    ): DataOrError<List<Song>>
}