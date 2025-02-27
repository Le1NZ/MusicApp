package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.main_screen.state.SkeletonSongState

private val MIN_HEIGHT = 200.dp

@Composable
internal fun SkeletonBlockSong(
    song: SkeletonSongState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(8),
            )
            .heightIn(min = MIN_HEIGHT)
            .background(Color.Gray)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomStart,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            SkeletonBlockSongTitle(
                title = song.title,
            )
            SkeletonBlockSongSubtitle(
                subtitle = song.artist,
            )
        }
    }
}

@Composable
private fun SkeletonBlockSongTitle(
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
private fun SkeletonBlockSongSubtitle(
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
            SkeletonBlockSong(
                song = SkeletonSongState.forPreview(),
            )
        }
    }
}