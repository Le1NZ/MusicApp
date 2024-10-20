package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.album.Album
import ru.pokrovskii.network.AlbumDto

internal fun AlbumDto.toAlbum(): Album {
    return Album(
        name = name,
        coverUrl = coverUrl,
        artistNames = artistNames,
    )
}