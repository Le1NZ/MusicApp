package ru.pokrovskii.network.search.api

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.MinimizedSong

interface SearchRepository {

    suspend fun getSearchResult(query: String): DataOrError<List<MinimizedSong>>
}