package ru.pokrovskii.screen.search.ui.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.search.R
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter
import ru.pokrovskii.song.item.api.ui.SongItemWrapper

@Composable
internal fun SearchScreenSuccess(
    state: SearchScreenState.Success,
    presenter: SearchScreenPresenter,
) {
    val songs = state.results
    if (songs.isEmpty()) {
        return EmptyState()
    }

    LazyColumn {
        items(songs) { song ->
            val songItemPresenter = presenter.createSongItemPresenter(songItem = song.model)
            SongItemWrapper(
                model = song.uiModel,
                presenter = songItemPresenter,
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
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(R.string.search_empty_state),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )
    }
}