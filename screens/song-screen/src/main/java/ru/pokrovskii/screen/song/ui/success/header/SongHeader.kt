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

val alphaOverlayList
    @Composable
    get() = listOf(
        MaterialTheme.colorScheme.background.copy(0f),
        MaterialTheme.colorScheme.background.copy(0.2f),
        MaterialTheme.colorScheme.background.copy(0.35f),
        MaterialTheme.colorScheme.background.copy(0.45f),
        MaterialTheme.colorScheme.background.copy(0.55f),
        MaterialTheme.colorScheme.background.copy(0.75f),
        MaterialTheme.colorScheme.background.copy(0.85f),
        MaterialTheme.colorScheme.background.copy(0.9f),
        MaterialTheme.colorScheme.background.copy(0.95f),
        MaterialTheme.colorScheme.background,
    )

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
            height = screenWidth  / 1.3f,
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
            .background(Brush.verticalGradient(alphaOverlayList)),
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