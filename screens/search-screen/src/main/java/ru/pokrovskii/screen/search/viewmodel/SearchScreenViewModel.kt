package ru.pokrovskii.screen.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.model.uilogic.UiLogicState
import ru.pokrovskii.screen.search.domain.SearchScreenCenter
import ru.pokrovskii.screen.search.ui.mapper.SongItemConverter
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import kotlin.time.Duration.Companion.milliseconds

internal class SearchScreenViewModel(
    private val searchScreenCenter: SearchScreenCenter,
) : ViewModel() {

    private var loadJob: Job? = null
    private var historyJob: Job? = null

    private val searchHistory = searchScreenCenter.history

    private val _state = MutableStateFlow<UiLogicState<MinimizedSong>>(
        value = UiLogicState.Success(emptyList()),
    )
    val state = combine(
        _state,
        searchHistory,
    ) { state, history ->
        when (state) {
            is UiLogicState.Loading -> SearchScreenState.Loading
            is UiLogicState.Error -> SearchScreenState.Error

            is UiLogicState.Success -> {
                if (state.data.isNotEmpty()) {
                    return@combine SearchScreenState.Success.Result(
                        results = state.data.map(SongItemConverter::convert),
                    )
                }

                if (history.isEmpty()) {
                    SearchScreenState.Success.History.Empty
                } else {
                    SearchScreenState.Success.History.Data(
                        history = history.map(SongItemConverter::convert)
                    )
                }
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = SearchScreenState.Loading,
    )

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun onQueryChanged(newQuery: String) {
        if (newQuery == query.value) return

        _query.value = newQuery
        getSearchResult(newQuery)
    }

    fun retry() {
        getSearchResult(query.value)
    }

    fun onSongClick(song: MinimizedSong) {
        historyJob?.cancel()
        historyJob = viewModelScope.launch {
            searchScreenCenter.addToHistory(
                song = song,
            )
        }
    }

    fun clearHistory() {
        historyJob?.cancel()
        historyJob = viewModelScope.launch {
            searchScreenCenter.clearHistory()
        }
    }

    private fun getSearchResult(query: String) {
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            if (query.isEmpty()) {
                _state.value = UiLogicState.Success(listOf())
                return@launch
            }

            _state.value = UiLogicState.Loading
            delay(DEBOUNCE_TIME)
            _state.value = searchScreenCenter.getSearchResult(query)
        }
    }

    override fun onCleared() {
        loadJob?.cancel()
        loadJob = null
        historyJob?.cancel()
        historyJob = null
        super.onCleared()
    }

    companion object {

        private val DEBOUNCE_TIME = 500.milliseconds
    }
}