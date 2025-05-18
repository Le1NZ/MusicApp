package ru.pokrovskii.screen.artist.ui.converter

import ru.pokrovskii.model.artist.FullArtist
import ru.pokrovskii.screen.artist.ui.state.FullArtistUiModel

internal fun FullArtist.toFullArtistUiModel(): FullArtistUiModel {
    return FullArtistUiModel(
        name = name,
        coverUrl = coverUrl,
        aka = aka?.takeIf { it.isNotEmpty() },
        followersCount = followersCount,
    )
}