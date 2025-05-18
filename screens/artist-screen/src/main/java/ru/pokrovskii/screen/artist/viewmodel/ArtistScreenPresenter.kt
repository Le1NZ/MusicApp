package ru.pokrovskii.screen.artist.viewmodel

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.screen.artist.api.ArtistScreenActions
import ru.pokrovskii.screen.artist.ui.state.ArtistScreenState

@Stable
internal interface ArtistScreenPresenter {

    val state: StateFlow<ArtistScreenState>

    fun onRetryClick()
    fun onAllSongsClick()
    fun onSearchClick()
    fun onFavoritesClick()
}

internal class ArtistScreenPresenterImpl(
    private val actions: ArtistScreenActions,
    private val viewModel: ArtistScreenViewModel,
) : ArtistScreenPresenter {

    override val state = viewModel.state

    override fun onRetryClick() {
        viewModel.loadArtist()
    }

    override fun onAllSongsClick() {
        actions.onAllSongsClick(id = viewModel.id)
    }

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }
}

internal class ArtistScreenPresenterPreview : ArtistScreenPresenter {

    override val state = MutableStateFlow(ArtistScreenState.forPreview())

    override fun onRetryClick() = Unit
    override fun onAllSongsClick() = Unit
    override fun onSearchClick() = Unit
    override fun onFavoritesClick() = Unit
}