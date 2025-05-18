package ru.pokrovskii.screen.song.viewmodel

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.screen.song.api.SongScreenActions
import ru.pokrovskii.screen.song.ui.state.SongScreenState

@Stable
internal interface SongScreenPresenter {

    val state: StateFlow<SongScreenState>

    fun onFavoritesClick()
    fun onSearchClick()
    fun onRetryClick()
    fun onLikeClick()
    fun onToTextButtonClick()
    fun onArtistClick(id: String)
}

internal class SongScreenPresenterImpl(
    private val actions: SongScreenActions,
    private val viewModel: SongScreenViewModel,
) : SongScreenPresenter {

    override val state = viewModel.state

    override fun onFavoritesClick() {
        actions.onFavoriteClick()
    }
    override fun onSearchClick() {
        actions.onSearchClick()
    }
    override fun onRetryClick() {
        viewModel.onRetryClick()
    }

    override fun onLikeClick() {
        viewModel.onLikeClick()
    }

    override fun onToTextButtonClick() {
        actions.onToTextButtonClick(
            url = (state.value as? SongScreenState.Success)?.songUiModel?.songTextUrl ?: return,
        )
    }

    override fun onArtistClick(id: String) {
        actions.onArtistClick(id = id)
    }
}

internal class SongScreenPresenterPreview : SongScreenPresenter {

    override val state = MutableStateFlow(SongScreenState.Loading)

    override fun onFavoritesClick() = Unit
    override fun onSearchClick() = Unit
    override fun onRetryClick() = Unit
    override fun onLikeClick() = Unit
    override fun onToTextButtonClick() = Unit
    override fun onArtistClick(id: String) = Unit
}