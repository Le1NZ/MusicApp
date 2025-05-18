package ru.pokrovskii.screen.artist.ui.success.header

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.pokrovskii.design.header.EntityHeader
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.screen.artist.ui.state.FullArtistUiModel

@Composable
internal fun ArtistHeader(
    artist: FullArtistUiModel,
    lazyListState: LazyListState,
    modifier: Modifier = Modifier,
) {
    EntityHeader(
        imageUrl = artist.coverUrl,
        lazyListState = lazyListState,
        modifier = modifier,
    ) {
        ArtistHeaderInfo(
            title = artist.name,
            followers = artist.followersCount,
        )
    }
}

@Composable
@Preview
private fun SongHeaderPreview() {
    AppTheme {
        Surface {
            ArtistHeader(
                artist = FullArtistUiModel.forPreview(),
                lazyListState = rememberLazyListState(),
            )
        }
    }
}