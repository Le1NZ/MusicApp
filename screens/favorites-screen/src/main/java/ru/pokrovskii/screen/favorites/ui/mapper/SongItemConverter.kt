package ru.pokrovskii.screen.favorites.ui.mapper

import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.favorites.ui.state.SongItem
import ru.pokrovskii.song.item.api.model.SongItemUiModelConverter

internal object SongItemConverter {

    fun convert(song: MinimizedSong): SongItem {
        return SongItem(
            model = song,
            uiModel = SongItemUiModelConverter.convert(song),
        )
    }
}