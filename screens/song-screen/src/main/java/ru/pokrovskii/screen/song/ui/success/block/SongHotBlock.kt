package ru.pokrovskii.screen.song.ui.success.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.song.R

@Composable
internal fun SongHotBlock(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiary),
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 48.dp, vertical = 6.dp),
                text = stringResource(id = R.string.hot),
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}