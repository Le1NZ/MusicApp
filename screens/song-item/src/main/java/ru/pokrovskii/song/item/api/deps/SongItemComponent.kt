package ru.pokrovskii.song.item.api.deps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelStore
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.viewmodel.SongItemPresenterImpl

class SongItemComponent(
    private val dependencies: SongItemDependencies,
) {

    private fun createPresenter(
        viewModelStore: ViewModelStore,
        songItem: MinimizedSong,
        fragmentManager: FragmentManager,
    ): SongItemPresenter {
        return SongItemPresenterImpl(
            viewModelStore = viewModelStore,
            song = songItem,
            actions = dependencies.createActions(fragmentManager),
        )
    }

    @Composable
    fun rememberPresenter(
        viewModelStore: ViewModelStore,
        songItem: MinimizedSong,
        fragmentManager: FragmentManager,
    ): SongItemPresenter {
        return remember(songItem) {
            createPresenter(
                viewModelStore = viewModelStore,
                songItem = songItem,
                fragmentManager = fragmentManager,
            )
        }
    }
}