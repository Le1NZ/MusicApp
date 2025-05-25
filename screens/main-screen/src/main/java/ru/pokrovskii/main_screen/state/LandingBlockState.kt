package ru.pokrovskii.main_screen.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class LandingBlockState(
    val id: String,
    val title: String,
    val songs: List<LandingSongState>,
) {

    companion object {

        fun forPreview(index: Int): LandingBlockState {
            return LandingBlockState(
                id = index.toString(),
                title = "Title_$index",
                songs = List(4) { LandingSongState.forPreview(it) },
            )
        }
    }
}
