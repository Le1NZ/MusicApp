package ru.pokrovskii.song.item.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.like.LikeButton
import ru.pokrovskii.song.item.api.model.SongItemUiModel
import ru.pokrovskii.song.item.api.ui.SongItemPresenter

private val HEIGHT = 64.dp

@Composable
internal fun SongItem(
    model: SongItemUiModel,
    presenter: SongItemPresenter,
    modifier: Modifier = Modifier,
) {
    val isLiked by presenter.isLiked.collectAsStateWithLifecycle()

    Row(
        modifier = modifier
            .height(HEIGHT)
            .fillMaxWidth()
            .clickable(onClick = presenter::onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            model.coverUrl?.let { url ->
                AsyncImage(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .size(48.dp),
                    model = imageRequestOf(url = url),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Column {
                Text(
                    text = model.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = model.artist,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }
        }

        LikeButton(
            modifier = Modifier
                .padding(start = 8.dp),
            isLiked = isLiked,
            onLikeClick = presenter::onLikeClick,
        )
    }
}
