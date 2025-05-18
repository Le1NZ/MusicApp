package ru.pokrovskii.network.artist_songs.impl

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.artist_songs.ArtistSongsApi
import ru.pokrovskii.network.artist_songs.api.ArtistSongsRepository
import ru.pokrovskii.network.artist_songs.api.ArtistSongsSortType
import ru.pokrovskii.network.mappers.toSong
import ru.pokrovskii.network.utils.toResult

internal class ArtistSongsRepositoryImpl(
    private val api: ArtistSongsApi,
) : ArtistSongsRepository {

    override suspend fun getArtistSongs(
        id: String,
        sortType: ArtistSongsSortType,
        countPerPage: Int,
        pageNumber: Int
    ): DataOrError<List<Song>> {
        return api.getArtistSongs(
            id = id,
            sortType = sortType.asApiString(),
            countPerPage = countPerPage,
            pageNumber = pageNumber,
        ).toResult { songs.map { it.toSong() } }
    }

    private fun ArtistSongsSortType.asApiString(): String {
        return when (this) {
            is ArtistSongsSortType.ByTitle -> "title"
            is ArtistSongsSortType.ByPopularity -> "popularity"
        }
    }
}