package ru.pokrovskii.screen.search.ui.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.search.R
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter
import ru.pokrovskii.song.item.api.ui.SongItemWrapper

@Composable
internal fun SearchScreenHistory(
    state: SearchScreenState.Success.History,
    presenter: SearchScreenPresenter,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is SearchScreenState.Success.History.Empty -> SearchScreenHistoryEmpty(
            modifier = modifier,
        )

        is SearchScreenState.Success.History.Data -> SearchScreenHistoryResults(
            state = state,
            presenter = presenter,
            modifier = modifier,
        )
    }
}

@Composable
private fun SearchScreenHistoryEmpty(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(top = 16.dp)
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

@Composable
private fun SearchScreenHistoryResults(
    state: SearchScreenState.Success.History.Data,
    presenter: SearchScreenPresenter,
    modifier: Modifier = Modifier,
) {
    val songs = state.history

    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp),
            text = stringResource(R.string.search_history),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        LazyColumn(
            modifier = modifier,
        ) {
            items(songs) { song ->
                val songItemPresenter = presenter.createSongItemPresenter(songItem = song.model)
                SongItemWrapper(
                    model = song.uiModel,
                    presenter = songItemPresenter,
                )
            }

            item {
                Button(
                    modifier = modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 16.dp),
                    onClick = presenter::clearHistory,
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 4.dp),
                        text = stringResource(R.string.clear_history),
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.navigationBarsPadding())
            }
        }
    }
}