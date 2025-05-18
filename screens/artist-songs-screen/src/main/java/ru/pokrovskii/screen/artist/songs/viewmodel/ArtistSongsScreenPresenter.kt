package ru.pokrovskii.screen.artist.songs.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenActions
import ru.pokrovskii.screen.artist.songs.ui.state.ArtistSongsScreenState
import ru.pokrovskii.song.item.api.deps.SongItemActions
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.api.ui.SongItemPresenterPreview

@Stable
internal interface ArtistSongsScreenPresenter {

    val state: StateFlow<ArtistSongsScreenState>

    fun onRetryClick()
    fun onSearchClick()
    fun onFavoritesClick()

    @Composable
    fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter
}

internal class ArtistSongsScreenPresenterImpl(
    private val actions: ArtistSongsScreenActions,
    private val viewModel: ArtistSongsScreenViewModel,
    private val viewModelStore: ViewModelStore,
) : ArtistSongsScreenPresenter {

    override val state = viewModel.state

    override fun onRetryClick() {
        viewModel.onRetryClick()
    }

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemComponent.rememberPresenter(
            viewModelStore = viewModelStore,
            songItem = songItem,
            actions = object : SongItemActions {

                override fun onSongItemClick(id: Int) {
                    actions.onSongClick(id)
                }
            }
        )
    }
}

internal class ArtistSongsScreenPresenterPreview : ArtistSongsScreenPresenter {

    override val state = MutableStateFlow(ArtistSongsScreenState.forPreview())

    override fun onRetryClick() = Unit
    override fun onSearchClick() = Unit
    override fun onFavoritesClick() = Unit

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemPresenterPreview()
    }
}