package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.artist.PrimaryArtist
import ru.pokrovskii.network.PrimaryArtistDto

internal fun PrimaryArtistDto.toPrimaryArtist(): PrimaryArtist {
    return PrimaryArtist(
        id = id,
        coverUrl = coverUrl,
        name = name,
    )
}