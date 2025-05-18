package ru.pokrovskii.screen.artist.ui.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface ArtistScreenState {

    data object Loading : ArtistScreenState
    data object Error : ArtistScreenState

    data class Success(
        val artist: FullArtistUiModel,
    ) : ArtistScreenState

    companion object {

        fun forPreview(): Success {
            return Success(
                artist = FullArtistUiModel.forPreview(),
            )
        }
    }
}