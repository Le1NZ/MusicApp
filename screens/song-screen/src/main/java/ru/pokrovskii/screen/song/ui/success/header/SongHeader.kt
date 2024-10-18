package ru.pokrovskii.screen.song.ui.success.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.screen.song.ui.state.SongUiModel

@Composable
internal fun SongHeader(
    songUiModel: SongUiModel,
    onLikeClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        songUiModel.coverUrl?.let {
            SongCover(coverUrl = it)
        }

        SongHeaderInfo(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            title = songUiModel.title,
            viewCount = songUiModel.pageViewCount,
            isLiked = songUiModel.isLiked,
            onLikeClick = onLikeClick,
        )
    }
}

@Composable
private fun SongCover(
    coverUrl: String,
    modifier: Modifier = Modifier,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .height(screenWidth)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = imageRequestOf(url = coverUrl),
            modifier = modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .matchParentSize(),
            contentDescription = null,
        )

        BottomOverlay(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            height = screenWidth / 3,
        )
    }
}

@Composable
private fun BottomOverlay(
    modifier: Modifier,
    height: Dp,
) {
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    0f to Color.Unspecified,
                    1f to MaterialTheme.colorScheme.background,
                )
            ),
    )
}


@Composable
@Preview
private fun SongHeaderPreview() {
    AppTheme {
        Surface {
            SongHeader(
                songUiModel = SongUiModel.PREVIEW,
                onLikeClick = {},
            )
        }
    }
}