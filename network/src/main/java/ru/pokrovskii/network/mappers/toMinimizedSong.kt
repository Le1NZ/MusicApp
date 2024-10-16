package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.network.search.dto.HitDto

internal fun HitDto.toMinimizedSong(): MinimizedSong {
    return MinimizedSong(
        id = song.id,
        title = song.title,
        coverUrl = song.coverUrl,
        artist = song.artist.toPrimaryArtist(),
    )
}