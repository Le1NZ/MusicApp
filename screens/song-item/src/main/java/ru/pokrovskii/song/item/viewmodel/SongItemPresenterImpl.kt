package ru.pokrovskii.song.item.viewmodel

import androidx.lifecycle.ViewModelStore
import org.koin.java.KoinJavaComponent.get
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.song.item.api.deps.SongItemActions
import ru.pokrovskii.song.item.api.ui.SongItemPresenter
import ru.pokrovskii.song.item.domain.SongItemCenter

internal class SongItemPresenterImpl(
    private val song: MinimizedSong,
    private val actions: SongItemActions,
    viewModelStore: ViewModelStore,
) : SongItemPresenter {

    private val viewModel by viewModelStore.viewModelFactory {
        SongItemViewModel(
            center = get(SongItemCenter::class.java),
        )
    }

    override val isLiked = viewModel.isLiked(song.id)

    override fun onClick() {
        actions.onSongItemClick(song.id)
    }

    override fun onLikeClick() {
        viewModel.onLikeClick(song, isLiked.value)
    }
}