package ru.pokrovskii.screen.search.ui.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import ru.pokrovskii.screen.search.R
import ru.pokrovskii.screen.search.ui.state.SearchScreenState

@Composable
internal fun SearchScreenSuccess(
    state: SearchScreenState.Success,
    onTrackClick: (Int) -> Unit,
) {
    val songs = state.results
    if (songs.isEmpty()) {
        return EmptyState()
    }

    LazyColumn {
        items(state.results) { song ->
            SongItem(
                model = song,
                onClick = onTrackClick,
            )
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
            text = stringResource(R.string.search_empty_state),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}