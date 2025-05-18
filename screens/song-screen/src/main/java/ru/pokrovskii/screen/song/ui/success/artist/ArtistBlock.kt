package ru.pokrovskii.screen.song.ui.success.artist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.artist.ArtistItem
import ru.pokrovskii.design.artist.ArtistItemUiModel
import ru.pokrovskii.screen.song.R

@Composable
internal fun PrimaryArtistsBlock(
    primaryArtists: List<ArtistItemUiModel>,
    onArtistClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ArtistsBlock(
        title = stringResource(R.string.primary_artists),
        artists = primaryArtists,
        onArtistClick = onArtistClick,
        modifier = modifier,
    )
}
@Composable
internal fun FeaturedArtistsBlock(
    featuredArtists: List<ArtistItemUiModel>,
    onArtistClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ArtistsBlock(
        title = stringResource(R.string.featured_artists),
        artists = featuredArtists,
        onArtistClick = onArtistClick,
        modifier = modifier,
    )
}
@Composable
internal fun ProducerArtistsBlock(
    producerArtists: List<ArtistItemUiModel>,
    onArtistClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    ArtistsBlock(
        title = stringResource(R.string.producer_artists),
        artists = producerArtists,
        onArtistClick = onArtistClick,
        modifier = modifier,
    )
}

@Composable
private fun ArtistsBlock(
    title: String,
    artists: List<ArtistItemUiModel>,
    onArtistClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .wrapContentHeight(),
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = title,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.secondary,
        )

        artists.forEach { artist ->
            ArtistItem(
                modifier = Modifier
                    .padding(top = 8.dp),
                onClick = onArtistClick,
                model = artist,
            )
        }
    }
}