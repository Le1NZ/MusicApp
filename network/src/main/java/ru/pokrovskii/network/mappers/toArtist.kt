package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.artist.Artist
import ru.pokrovskii.network.ArtistDto

internal fun ArtistDto.toArtist(): Artist {
    return Artist(
        id = id,
        coverUrl = coverUrl,
        name = name,
    )
}