package ru.pokrovskii.screen.favorites.viewmodel

import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelStore
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.favorites.api.FavoritesScreenActions
import ru.pokrovskii.song.item.api.deps.SongItemComponent
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.api.ui.SongItemPresenterPreview

internal interface FavoritesScreenPresenter {

    fun onSongClick(id: Int)
    fun onSearchClick()

    @Composable
    fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter
}

internal class FavoritesScreenPresenterImpl(
    private val actions: FavoritesScreenActions,
    private val songItemComponent: SongItemComponent,
    private val viewModelStore: ViewModelStore,
    private val fragmentManager: FragmentManager,
) : FavoritesScreenPresenter {

    override fun onSongClick(id: Int) {
        actions.onSongClick(id)
    }

    override fun onSearchClick() {
        actions.onSearchClick()
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

internal class FavoritesScreenPresenterPreview : FavoritesScreenPresenter {

    override fun onSongClick(id: Int) = Unit
    override fun onSearchClick() = Unit

    @Composable
    override fun createSongItemPresenter(songItem: MinimizedSong): SongItemPresenter {
        return SongItemPresenterPreview()
    }
}