package ru.pokrovskii.design.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.pokrovskii.design.coil.imageRequestOf
import ru.pokrovskii.design.modifier.alpha
import ru.pokrovskii.design.modifier.parallaxEffect

@Composable
fun EntityHeader(
    imageUrl: String?,
    lazyListState: LazyListState,
    modifier: Modifier = Modifier,
    headerInfo: @Composable BoxScope.() -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        imageUrl?.let {
            EntityHeaderCover(
                coverUrl = it,
                lazyListState = lazyListState,
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            content = headerInfo,
        )
    }
}

@Composable
private fun EntityHeaderCover(
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
