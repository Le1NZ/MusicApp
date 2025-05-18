package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.artist.FullArtist
import ru.pokrovskii.network.artist.dto.FullArtistDto

internal fun FullArtistDto.toFullArtist(): FullArtist {
    return FullArtist(
        id = id,
        coverUrl = coverUrl,
        name = name,
        aka = aka,
        followersCount = followersCount,
    )
}