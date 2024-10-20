package ru.pokrovskii.screen.search.ui.mapper

import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.screen.search.ui.state.SongItem
import ru.pokrovskii.song.item.api.model.SongItemUiModelConverter

internal object SongItemConverter {

    fun convert(song: MinimizedSong): SongItem {
        return SongItem(
            model = song,
            uiModel = SongItemUiModelConverter.convert(song),
        )
    }
}