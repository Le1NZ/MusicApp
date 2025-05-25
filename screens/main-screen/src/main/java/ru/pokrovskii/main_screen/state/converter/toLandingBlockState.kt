package ru.pokrovskii.main_screen.state.converter

import ru.pokrovskii.main_screen.state.LandingBlockState
import ru.pokrovskii.main_screen.state.LandingSongState
import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.landing.LandingSong

internal fun LandingBlock.toLandingBlockState(canEdit: Boolean): LandingBlockState {
    return LandingBlockState(
        id = id,
        title = title,
        songs = songs.map { it.toLandingSongState() }.toMutableList().also {
            if (canEdit) {
                it.add(LandingSongState.Add)
            }
        },
    )
}

private fun LandingSong.toLandingSongState(): LandingSongState {
    return LandingSongState.Song(
        id = id,
        imageUrl = imageUrl,
        title = title,
        artist = artist,
    )
}