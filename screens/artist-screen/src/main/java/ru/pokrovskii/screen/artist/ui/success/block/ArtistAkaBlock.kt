package ru.pokrovskii.screen.artist.ui.success.block

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.artist.R

@Composable
internal fun ArtistAkaBlock(
    akaList: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .wrapContentHeight(),
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = stringResource(id = R.string.artist_aka),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.secondary,
        )

        akaList.forEach { name ->
            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp),
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
    }
}
