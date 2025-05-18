package ru.pokrovskii.screen.artist.ui.state

import androidx.compose.runtime.Immutable

@Immutable
internal data class FullArtistUiModel(
    val name: String,
    val coverUrl: String?,
    val aka: List<String>?,
    val followersCount: Long?,
) {

    companion object {

        fun forPreview(): FullArtistUiModel {
            return FullArtistUiModel(
                name = "Markul",
                coverUrl = null,
                aka = listOf("Markul 1, Markul 2"),
                followersCount = 100,
            )
        }
    }
}
