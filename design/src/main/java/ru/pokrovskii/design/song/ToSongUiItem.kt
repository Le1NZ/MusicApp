package ru.pokrovskii.design.song

import ru.pokrovskii.model.song.MinimizedSong

object ToSongUiModel {

    fun convert(song: MinimizedSong): SongItemUiModel {
        return SongItemUiModel(
            id = song.id,
            coverUrl = song.coverUrl,
            title = song.title,
            artist = song.artist.name,
        )
    }
}