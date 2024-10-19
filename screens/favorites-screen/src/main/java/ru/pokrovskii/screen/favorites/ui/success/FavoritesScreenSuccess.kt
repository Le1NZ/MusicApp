package ru.pokrovskii.screen.favorites.ui.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.song.SongItem
import ru.pokrovskii.screen.favorites.R
import ru.pokrovskii.screen.favorites.ui.state.FavoritesScreenState

@Composable
internal fun FavoritesScreenSuccess(
    state: FavoritesScreenState.Success,
    onSongClick: (Int) -> Unit,
) {

    val songs = state.songs
    if (songs.isEmpty()) {
        return EmptyState()
    }

    LazyColumn {
        items(state.songs) { song ->
            SongItem(
                model = song,
                onClick = onSongClick,
            )
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}


@Composable
private fun EmptyState() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.favorites_empty_state),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}