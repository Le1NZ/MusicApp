package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.header.BottomOverlay
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.main_screen.R
import ru.pokrovskii.main_screen.state.LandingSongState
import ru.pokrovskii.main_screen.ui.edit.canEdit

private val MIN_HEIGHT = 300.dp
private val OVERLAY_HEIGHT = 100.dp

@Composable
internal fun LandingBlockSong(
    song: LandingSongState.Song,
    onClick: (Int) -> Unit,
    onSongDelete: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(8),
            )
            .clickable(
                onClick = { onClick(song.id) },
            )
            .heightIn(min = MIN_HEIGHT)
            .background(Color.Gray)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomStart,
    ) {
        AsyncImage(
            modifier = Modifier
                .matchParentSize(),
            model = song.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )

        BottomOverlay(
            modifier = Modifier.align(Alignment.BottomCenter),
            height = OVERLAY_HEIGHT,
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            LandingBlockSongTitle(
                title = song.title,
            )
            LandingBlockSongSubtitle(
                subtitle = song.artist,
            )
        }

        if (canEdit) {
            IconButton(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceTint)
                    .align(Alignment.TopEnd)
                    .wrapContentSize(),
                onClick = { onSongDelete(song.id) },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_outline_24),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.inverseOnSurface,
                )
            }
        }
    }
}

@Composable
internal fun AddLandingBlockSong(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(8),
            )
            .clickable(
                onClick = onClick,
            )
            .heightIn(min = MIN_HEIGHT)
            .background(Color.Gray)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        BottomOverlay(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            height = OVERLAY_HEIGHT,
        )

        Icon(
            modifier = Modifier
                .size(48.dp),
            painter = painterResource(id = R.drawable.baseline_add_24),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
private fun LandingBlockSongTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = title,
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold,
        color = MaterialTheme.colorScheme.onBackground,
        lineHeight = 40.sp,
    )
}

@Composable
private fun LandingBlockSongSubtitle(
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = subtitle,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onSurface,
        lineHeight = 28.sp,
    )
}

@Preview
@Composable
private fun SkeletonBlockSongPreview() {
    AppTheme {
        Surface {
            LandingBlockSong(
                song = LandingSongState.forPreview(id = 1),
                onClick = { },
                onSongDelete = { },
            )
        }
    }
}