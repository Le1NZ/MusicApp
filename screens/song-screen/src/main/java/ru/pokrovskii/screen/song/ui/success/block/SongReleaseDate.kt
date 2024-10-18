package ru.pokrovskii.screen.song.ui.success.block

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.song.R

@Composable
internal fun SongReleaseDate(
    releaseDate: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp),
        text = stringResource(R.string.release_data, releaseDate),
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.onBackground,
        fontWeight = FontWeight.SemiBold,
    )
}