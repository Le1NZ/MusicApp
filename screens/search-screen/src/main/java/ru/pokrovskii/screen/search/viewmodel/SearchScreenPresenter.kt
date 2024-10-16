package ru.pokrovskii.screen.search.viewmodel

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.screen.search.api.SearchScreenActions

@Stable
internal interface SearchScreenPresenter {

    val query: StateFlow<String>

    fun onFavoritesClick()
    fun onRetryClick()
    fun onQueryChanged(query: String)
    fun onTrackClick(id: Int)
}

internal class SearchScreenPresenterImpl(
    private val actions: SearchScreenActions,
    private val viewModel: SearchScreenViewModel,
) : SearchScreenPresenter {

    override val query = viewModel.query

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    override fun onRetryClick() {
        viewModel.retry()
    }

    override fun onQueryChanged(query: String) {
        viewModel.onQueryChanged(query)
    }

    override fun onTrackClick(id: Int) {
        actions.openSongScreen(id)
    }
}

internal class SearchScreenPresenterPreview : SearchScreenPresenter {

    override val query = MutableStateFlow("")

    override fun onFavoritesClick() { }
    override fun onRetryClick() { }
    override fun onQueryChanged(query: String) { }
    override fun onTrackClick(id: Int) { }
}