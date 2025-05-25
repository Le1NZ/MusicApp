package ru.pokrovskii.main_screen.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface LandingSongState {

    val id: Int

    data object Add : LandingSongState {

        override val id = -1
    }

    data class Song(
        override val id: Int,
        val imageUrl: String,
        val title: String,
        val artist: String,
    ) : LandingSongState

    companion object {
        fun forPreview(id: Int): Song {
            return Song(
                id = id,
                imageUrl = "",
                title = "Some Song",
                artist = "Some Artist",
            )
        }
    }
}
