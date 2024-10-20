package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.song.Song
import ru.pokrovskii.model.utils.takeIfNotNull
import ru.pokrovskii.network.song.dto.SongDto

internal fun SongDto.toSong(): Song {
    return Song(
        id = id,
        title = title,
        releaseDate = releaseDate,
        pageViewCount = stats.pageViewCount,
        isHot = stats.isHot,
        coverUrl = coverUrl,
        songTextUrl = textUrl,
        recordingLocation = recordingLocation,
        artists = primaryArtists.map { it.toArtist() },
        producers = producerArtists.takeIfNotNull()?.map { it.toArtist() },
        featuredArtists = featuredArtists.takeIfNotNull()?.map { it.toArtist() },
        album = album?.toAlbum(),
    )
}