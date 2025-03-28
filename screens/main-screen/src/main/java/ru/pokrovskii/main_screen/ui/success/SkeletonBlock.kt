package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.main_screen.state.SkeletonSongState

@Composable
internal fun SkeletonBlock(
    name: String,
    songs: List<SkeletonSongState>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp),
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        SkeletonBlockHorizontalPager(
            songs = songs,
        )
    }
}

@Composable
private fun SkeletonBlockHorizontalPager(
    songs: List<SkeletonSongState>,
    modifier: Modifier = Modifier,
) {
    val state = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { songs.size },
    )

    HorizontalPager(
        modifier = modifier,
        state = state,
        pageSpacing = 8.dp,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
        ),
    ) { page ->
        val song = songs[page]
        SkeletonBlockSong(
            song = song,
        )
    }
}

@Preview
@Composable
private fun SkeletonBlockPreview() {
    AppTheme {
        Surface {
            SkeletonBlock(
                name = "Test",
                songs = listOf(
                    SkeletonSongState.forPreview(),
                    SkeletonSongState.forPreview(),
                    SkeletonSongState.forPreview(),
                ),
            )
        }
    }
}