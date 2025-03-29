package ru.pokrovskii.screen.favorites.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStore
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.favorites.api.FavoritesScreenActions
import ru.pokrovskii.song.item.api.deps.SongItemActions
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.api.ui.SongItemPresenterPreview

internal interface FavoritesScreenPresenter {

    fun onSearchClick()
    fun onAccountClick()

    @Composable
    fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter
}

internal class FavoritesScreenPresenterImpl(
    private val actions: FavoritesScreenActions,
    private val viewModelStore: ViewModelStore,
) : FavoritesScreenPresenter {

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun onAccountClick() {
        actions.onAccountClick()
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

internal class FavoritesScreenPresenterPreview : FavoritesScreenPresenter {

    override fun onSearchClick() = Unit
    override fun onAccountClick() = Unit

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemPresenterPreview()
    }
}