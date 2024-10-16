package ru.pokrovskii.design.song

import ru.pokrovskii.model.song.MinimizedSong

object ToSongUiModel {

    fun convert(song: MinimizedSong): SongUiModel {
        return SongUiModel(
            id = song.id,
            coverUrl = song.coverUrl,
            title = song.title,
            artist = song.artist.name,
        )
    }
}