package ru.pokrovskii.screen.song.ui.success.header

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.pokrovskii.design.header.EntityHeader
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.screen.song.ui.state.SongUiModel

@Composable
internal fun SongHeader(
    songUiModel: SongUiModel,
    lazyListState: LazyListState,
    onLikeClick: () -> Unit,
) {
    EntityHeader(
        imageUrl = songUiModel.coverUrl,
        lazyListState = lazyListState,
    ) {
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