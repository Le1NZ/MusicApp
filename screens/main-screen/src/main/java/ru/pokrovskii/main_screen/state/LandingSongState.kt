package ru.pokrovskii.main_screen.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class LandingSongState(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val artist: String,
) {

    companion object {

        fun forPreview(id: Int): LandingSongState {
            return LandingSongState(
                id = id,
                imageUrl = "",
                title = "Some Song",
                artist = "Some Artist",
            )
        }
    }
}
