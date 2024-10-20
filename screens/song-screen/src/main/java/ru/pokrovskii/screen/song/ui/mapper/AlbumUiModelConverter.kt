package ru.pokrovskii.screen.song.ui.mapper

import ru.pokrovskii.model.album.Album
import ru.pokrovskii.screen.song.ui.state.AlbumUiModel

internal object AlbumUiModelConverter {

    fun convert(album: Album): AlbumUiModel {
        return AlbumUiModel(
            name = album.name,
            artistNames = album.artistNames,
            coverUrl = album.coverUrl,
        )
    }
}