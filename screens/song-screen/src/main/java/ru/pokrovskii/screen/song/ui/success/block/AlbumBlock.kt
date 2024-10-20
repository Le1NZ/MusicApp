package ru.pokrovskii.screen.song.ui.success.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.screen.song.R
import ru.pokrovskii.screen.song.ui.state.AlbumUiModel

private val COVER_SIZE = 72.dp

@Composable
internal fun AlbumBlock(
    album: AlbumUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp),
            text = stringResource(R.string.album),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.secondary,
        )

        Row(
            modifier = Modifier
                .heightIn(min = COVER_SIZE),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            album.coverUrl?.let { coverUrl ->
                AsyncImage(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .size(COVER_SIZE),
                    model = imageRequestOf(url = coverUrl),
                    contentDescription = null,
                )
            }

            Column {
                Text(
                    text = album.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                Text(
                    modifier = Modifier
                        .padding(top = 4.dp),
                    text = album.artistNames,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }
    }

}

@Composable
@Preview
private fun AlbumBlockPreview() {
    AppTheme {
        Surface {
            AlbumBlock(
                album = AlbumUiModel(
                    name = "Great depression",
                    artistNames = "Markul",
                    coverUrl = null,
                )
            )
        }
    }
}