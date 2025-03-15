package ru.pokrovskii.screen.search.domain

import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.model.uilogic.UiLogicState
import ru.pokrovskii.network.search.api.SearchRepository
import ru.pokrovskii.screen.search.history.HistoryStorage

internal class SearchScreenCenter(
    private val repository: SearchRepository,
    private val storage: HistoryStorage,
) {

    val history = storage.searchHistory

    suspend fun getSearchResult(query: String): UiLogicState<MinimizedSong> {
        return when (val result = repository.getSearchResult(query)) {
            is DataOrError.Error -> UiLogicState.Error
            is DataOrError.Data -> UiLogicState.Success(result.data)
        }
    }

    suspend fun addToHistory(song: MinimizedSong) {
        storage.addToHistory(
            song = song,
        )
    }

    suspend fun clearHistory() {
        storage.clearHistory()
    }
}