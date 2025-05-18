package ru.pokrovskii.screen.artist.songs.domain

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.network.artist_songs.api.ArtistSongsRepository
import ru.pokrovskii.network.artist_songs.api.ArtistSongsSortType

internal class ArtistSongsScreenCenter(
    private val repository: ArtistSongsRepository,
) {

    suspend fun getArtistSongs(id: String): List<Song>? {
        val result = repository.getArtistSongs(
            id = id,
            sortType = ArtistSongsSortType.ByPopularity,
            countPerPage = DEFAULT_COUNT_PER_PAGE,
            pageNumber = DEFAULT_PAGE_NUMBER,
        )

        return when (result) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }

    companion object {

        private const val DEFAULT_COUNT_PER_PAGE = 50
        private const val DEFAULT_PAGE_NUMBER = 1
    }
}