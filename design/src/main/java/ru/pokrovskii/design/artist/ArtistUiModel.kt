package ru.pokrovskii.design.artist

import androidx.compose.runtime.Immutable

@Immutable
data class ArtistItemUiModel(
    val id: String,
    val name: String,
    val coverUrl: String?,
) {

    companion object {

        val PREVIEW = ArtistItemUiModel(
            id = "1",
            name = "Markul",
            coverUrl = null,
        )
    }
}
