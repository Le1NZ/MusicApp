package ru.pokrovskii.network.landing.dto

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.landing.LandingSong

internal fun LandingBlockDto.toLandingBlock(): LandingBlock {
    return LandingBlock(
        id = id,
        title = title,
        songs = songs.map { it.toLandingSong() },
    )
}

private fun LandingSongDto.toLandingSong(): LandingSong {
    return LandingSong(
        id = id,
        title = title,
        imageUrl = imageUrl,
        artist = artist,
    )
}