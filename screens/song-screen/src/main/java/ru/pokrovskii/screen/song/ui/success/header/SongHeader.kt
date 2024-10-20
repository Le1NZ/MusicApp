package ru.pokrovskii.screen.song.ui.success.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.modifier.alpha
import ru.pokrovskii.design.modifier.parallaxEffect
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.screen.song.ui.state.SongUiModel

@Composable
internal fun SongHeader(
    songUiModel: SongUiModel,
    lazyListState: LazyListState,
    onLikeClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        songUiModel.coverUrl?.let {
            SongCover(
                coverUrl = it,
                lazyListState = lazyListState,
            )
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
    lazyListState: LazyListState,
    modifier: Modifier = Modifier,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val headerController = rememberOverlayAlphaController(lazyListState)

    Box(
        modifier = Modifier
            .height(screenWidth)
            .fillMaxWidth()
            .parallaxEffect(lazyListState, 4f)
            .alpha { headerController.coverOverlayAlpha }
    ) {
        AsyncImage(
            model = imageRequestOf(url = coverUrl),
            modifier = modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .matchParentSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        BottomOverlay(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            height = screenWidth / 2.5f,
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
            .background(Brush.verticalGradient(
                0f to Color.Unspecified,
                .1f to MaterialTheme.colorScheme.background.copy(0.5f),
                .15f to MaterialTheme.colorScheme.background.copy(0.7f),
                .2f to MaterialTheme.colorScheme.background.copy(0.8f),
                .3f to MaterialTheme.colorScheme.background.copy(0.85f),
                .4f to MaterialTheme.colorScheme.background.copy(0.9f),
                .5f to MaterialTheme.colorScheme.background.copy(0.95f),
                .6f to MaterialTheme.colorScheme.background.copy(0.98f),
                1f to MaterialTheme.colorScheme.background,
            )),
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
                lazyListState = rememberLazyListState(),
            )
        }
    }
}