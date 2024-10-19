package ru.pokrovskii.screen.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.design.song.SongItemUiModelConverter
import ru.pokrovskii.screen.search.domain.SearchScreenCenter
import ru.pokrovskii.screen.search.ui.state.SearchScreenState

internal class SearchScreenViewModel(
    private val searchScreenCenter: SearchScreenCenter,
) : ViewModel() {

    private var loadJob: Job? = null

    private val _state = MutableStateFlow<SearchScreenState>(SearchScreenState.Success(listOf()))
    val state = _state.asStateFlow()
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun onQueryChanged(query: String) {
        _query.value = query
        if (query.isEmpty()) {
            _state.value = SearchScreenState.Success(listOf())
            return
        }
        getSearchResult(query)
    }

    fun retry() {
        getSearchResult(query.value)
    }

    private fun getSearchResult(query: String) {
        _state.value = SearchScreenState.Loading

        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = searchScreenCenter.getSearchResult(query)
            _state.value = if (result == null) {
                SearchScreenState.Error
            } else {
                SearchScreenState.Success(result.map(SongItemUiModelConverter::convert))
            }
        }
    }

    override fun onCleared() {
        loadJob?.cancel()
        loadJob = null
        super.onCleared()
    }
}