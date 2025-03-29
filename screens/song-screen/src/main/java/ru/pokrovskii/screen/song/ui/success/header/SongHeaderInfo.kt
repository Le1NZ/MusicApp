package ru.pokrovskii.screen.song.ui.success.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.screen.song.R
import ru.pokrovskii.screen.song.ui.state.SongUiModel
import ru.pokrovskii.design.like.LikeButton

@Composable
internal fun SongHeaderInfo(
    title: String,
    viewCount: Long,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = title,
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground,
            lineHeight = 40.sp,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ViewCount(viewCount = viewCount)

            LikeButton(
                isLiked = isLiked,
                onLikeClick = onLikeClick,
            )
        }
    }
}

@Composable
private fun ViewCount(
    viewCount: Long,
) {
    Box(
        modifier = Modifier
            .heightIn(min = 40.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceTint)
            .wrapContentSize(),
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 4.dp),
            text = stringResource(R.string.view_count, viewCount),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.inverseOnSurface,
        )
    }
}

@Composable
@Preview
private fun SongHeaderInfoPreview() {
    AppTheme {
        Surface {
            SongHeaderInfo(
                title = SongUiModel.PREVIEW.title,
                viewCount = SongUiModel.PREVIEW.pageViewCount,
                isLiked = SongUiModel.PREVIEW.isLiked,
                onLikeClick = {},
            )
        }
    }
}