package ru.pokrovskii.main_screen.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.main_screen.api.MainScreenActions
import ru.pokrovskii.main_screen.state.MainScreenState

internal interface MainScreenPresenter {

    val state: StateFlow<MainScreenState>

    fun onSearchClick()
    fun onFavoritesClick()
    fun onSongClick(id: Int)
    fun onRetryClick()
}

internal class MainScreenPresenterImpl(
    private val actions: MainScreenActions,
    private val viewModel: MainScreenViewModel,
) : MainScreenPresenter {

    override val state = viewModel.state

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    override fun onSongClick(id: Int) {
        actions.onSongClick(id = id)
    }

    override fun onRetryClick() {
        viewModel.onRetryClick()
    }
}

internal class MainScreenPresenterPreview : MainScreenPresenter {

    override val state = MutableStateFlow(MainScreenState.forPreview())

    override fun onSearchClick() = Unit
    override fun onFavoritesClick() = Unit
    override fun onSongClick(id: Int) = Unit
    override fun onRetryClick() = Unit
}