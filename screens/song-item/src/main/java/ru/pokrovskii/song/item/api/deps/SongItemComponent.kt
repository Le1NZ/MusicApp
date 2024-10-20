package ru.pokrovskii.song.item.api.deps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelStore
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.viewmodel.SongItemPresenterImpl

object SongItemComponent {

    private fun createPresenter(
        viewModelStore: ViewModelStore,
        songItem: MinimizedSong,
        actions: SongItemActions,
    ): SongItemPresenter {
        return SongItemPresenterImpl(
            viewModelStore = viewModelStore,
            song = songItem,
            actions = actions,
        )
    }

    @Composable
    fun rememberPresenter(
        viewModelStore: ViewModelStore,
        songItem: MinimizedSong,
        actions: SongItemActions,
    ): SongItemPresenter {
        return remember(songItem) {
            createPresenter(
                viewModelStore = viewModelStore,
                songItem = songItem,
                actions = actions,
            )
        }
    }
}