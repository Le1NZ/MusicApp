package ru.pokrovskii.network.search.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.network.mappers.toMinimizedSong
import ru.pokrovskii.network.search.SearchApi
import ru.pokrovskii.network.search.api.SearchRepository
import ru.pokrovskii.network.utils.toResult

internal class SearchRepositoryImpl(
    private val api: SearchApi,
) : SearchRepository {

    override suspend fun getSearchResult(query: String): DataOrError<List<MinimizedSong>> {
        return withContext(Dispatchers.IO) {
            api
                .getSearchResult(query)
                .toResult { hits.map { it.toMinimizedSong() } }
        }
    }
}