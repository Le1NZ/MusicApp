package ru.pokrovskii.screen.song.ui.success.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.component.TextWithBackground
import ru.pokrovskii.design.like.LikeButton
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.screen.song.R
import ru.pokrovskii.screen.song.ui.state.SongUiModel

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
            TextWithBackground(
                text = stringResource(R.string.view_count, viewCount),
            )

            LikeButton(
                isLiked = isLiked,
                onLikeClick = onLikeClick,
            )
        }
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