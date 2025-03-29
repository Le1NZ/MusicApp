package ru.pokrovskii.design.artist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.theme.api.AppTheme

@Composable
fun ArtistItem(
    model: ArtistItemUiModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .heightIn(min = 48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        model.coverUrl?.let {
            AsyncImage(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer),
                model = imageRequestOf(url = model.coverUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }

        Text(
            text = model.name,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
@Preview
private fun ArtistItemPreview() {
    AppTheme {
        Surface {
            ArtistItem(model = ArtistItemUiModel.PREVIEW)
        }
    }
}