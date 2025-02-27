package ru.pokrovskii.main_screen.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class SkeletonSongState(
    val title: String,
    val artist: String,
) {

    companion object {

        fun forPreview(): SkeletonSongState {
            return SkeletonSongState(
                title = "Some Song",
                artist = "Some Artist",
            )
        }
    }
}
