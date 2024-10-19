package ru.pokrovskii.screen.search.domain

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.network.search.api.SearchRepository

internal class SearchScreenCenter(
    private val repository: SearchRepository,
) {

    suspend fun getSearchResult(query: String): List<MinimizedSong>? {
        return when (val result = repository.getSearchResult(query)) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }
}