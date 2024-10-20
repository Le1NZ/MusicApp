package ru.pokrovskii.screen.search.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.search.api.SearchScreenActions
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.api.ui.SongItemPresenterPreview

@Stable
internal interface SearchScreenPresenter {

    val query: StateFlow<String>

    fun onFavoritesClick()
    fun onRetryClick()
    fun onQueryChanged(query: String)
    fun onTrackClick(id: Int)

    @Composable
    fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter
}

internal class SearchScreenPresenterImpl(
    private val actions: SearchScreenActions,
    private val viewModel: SearchScreenViewModel,
    private val songItemComponent: SongItemComponent,
    private val viewModelStore: ViewModelStore,
    private val fragmentManager: FragmentManager,
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

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return songItemComponent.rememberPresenter(
            viewModelStore = viewModelStore,
            songItem = songItem,
            fragmentManager = fragmentManager,
        )
    }
}

internal class SearchScreenPresenterPreview : SearchScreenPresenter {

    override val query = MutableStateFlow("")

    override fun onFavoritesClick() { }
    override fun onRetryClick() { }
    override fun onQueryChanged(query: String) { }
    override fun onTrackClick(id: Int) { }

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemPresenterPreview()
    }
}