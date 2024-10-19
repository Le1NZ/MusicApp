package ru.pokrovskii.database.dbo.mapper

import ru.pokrovskii.database.dbo.MinimizedSongDbo
import ru.pokrovskii.model.song.MinimizedSong

internal object MinimizedSongConverter {

    fun convert(song: MinimizedSong): MinimizedSongDbo {
        return MinimizedSongDbo(
            id = song.id,
            title = song.title,
            coverUrl = song.coverUrl,
            artistName = song.artistName,
        )
    }

    fun convert(song: MinimizedSongDbo): MinimizedSong {
        return MinimizedSong(
            id = song.id,
            title = song.title,
            coverUrl = song.coverUrl,
            artistName = song.artistName,
        )
    }
}