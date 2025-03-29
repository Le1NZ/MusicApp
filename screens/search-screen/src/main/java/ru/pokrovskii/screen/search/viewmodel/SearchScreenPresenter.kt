package ru.pokrovskii.screen.search.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.search.api.SearchScreenActions
import ru.pokrovskii.song.item.api.deps.SongItemActions
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.api.ui.SongItemPresenterPreview

@Stable
internal interface SearchScreenPresenter {

    val query: StateFlow<String>

    fun onFavoritesClick()
    fun onAccountClick()
    fun onRetryClick()
    fun onQueryChanged(query: String)
    fun clearHistory()

    @Composable
    fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter
}

internal class SearchScreenPresenterImpl(
    private val actions: SearchScreenActions,
    private val viewModel: SearchScreenViewModel,
    private val viewModelStore: ViewModelStore,
) : SearchScreenPresenter {

    override val query = viewModel.query

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    override fun onAccountClick() {
        actions.onAccountClick()
    }

    override fun onRetryClick() {
        viewModel.retry()
    }

    override fun onQueryChanged(query: String) {
        viewModel.onQueryChanged(query)
    }

    override fun clearHistory() {
        viewModel.clearHistory()
    }

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemComponent.rememberPresenter(
            viewModelStore = viewModelStore,
            songItem = songItem,
            actions = object : SongItemActions {

                override fun onSongItemClick(id: Int) {
                    actions.openSongScreen(id)
                    viewModel.onSongClick(
                        song = songItem,
                    )
                }
            }
        )
    }
}

internal class SearchScreenPresenterPreview : SearchScreenPresenter {

    override val query = MutableStateFlow("")

    override fun onFavoritesClick() = Unit
    override fun onAccountClick() = Unit
    override fun onRetryClick() = Unit
    override fun onQueryChanged(query: String) = Unit
    override fun clearHistory() = Unit

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemPresenterPreview()
    }
}