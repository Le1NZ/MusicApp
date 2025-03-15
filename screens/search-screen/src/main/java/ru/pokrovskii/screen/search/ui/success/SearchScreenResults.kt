package ru.pokrovskii.screen.search.ui.success

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter
import ru.pokrovskii.song.item.api.ui.SongItemWrapper

@Composable
internal fun SearchScreenResults(
    state: SearchScreenState.Success.Result,
    presenter: SearchScreenPresenter,
    modifier: Modifier = Modifier,
) {
    val songs = state.results

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
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}