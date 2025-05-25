package ru.pokrovskii.main_screen.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.main_screen.api.MainScreenActions
import ru.pokrovskii.main_screen.state.MainScreenState

internal interface MainScreenPresenter {

    val state: StateFlow<MainScreenState>
    val canEdit: StateFlow<Boolean>

    fun onSearchClick()
    fun onFavoritesClick()

    fun onSongClick(id: Int)
    fun onSongDelete(id: Int, blockId: String)
    fun onBlockTitleChanged(id: String, newTitle: String)

    fun onSongAdd(
        id: String,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String
    )

    fun onBlockAdd()

    fun onRetryClick()
}

internal class MainScreenPresenterImpl(
    private val actions: MainScreenActions,
    private val viewModel: MainScreenViewModel,
) : MainScreenPresenter {

    override val state = viewModel.state
    override val canEdit = viewModel.canEdit

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    override fun onSongClick(id: Int) {
        actions.onSongClick(id = id)
    }

    override fun onSongDelete(id: Int, blockId: String) {
        viewModel.onSongDelete(
            id = id,
            blockId = blockId,
        )
    }

    override fun onBlockTitleChanged(id: String, newTitle: String) {
        viewModel.onBlockTitleChanged(
            id = id,
            newTitle = newTitle,
        )
    }

    override fun onSongAdd(
        id: String,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String,
    ) {
        viewModel.onSongAdd(
            id = id,
            title = title,
            artist = artist,
            imageUrl = imageUrl,
            blockId = blockId,
        )
    }

    override fun onBlockAdd() {
        viewModel.onBlockAdd()
    }

    override fun onRetryClick() {
        viewModel.onRetryClick()
    }
}

internal class MainScreenPresenterPreview : MainScreenPresenter {

    override val state = MutableStateFlow(MainScreenState.forPreview())
    override val canEdit = MutableStateFlow(false)

    override fun onSearchClick() = Unit
    override fun onFavoritesClick() = Unit
    override fun onSongClick(id: Int) = Unit
    override fun onSongDelete(id: Int, blockId: String) = Unit
    override fun onBlockTitleChanged(id: String, newTitle: String) = Unit
    override fun onSongAdd(
        id: String,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String
    ) = Unit

    override fun onBlockAdd() = Unit
    override fun onRetryClick() = Unit
}