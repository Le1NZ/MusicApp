package ru.pokrovskii.design.artist

import ru.pokrovskii.model.artist.Artist

object ArtistUiModelConverter {

    fun convert(artist: Artist): ArtistItemUiModel {
        return ArtistItemUiModel(
            id = artist.id,
            name = artist.name,
            coverUrl = artist.coverUrl,
        )
    }
}