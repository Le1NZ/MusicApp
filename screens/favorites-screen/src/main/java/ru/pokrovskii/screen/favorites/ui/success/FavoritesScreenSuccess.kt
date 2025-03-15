package ru.pokrovskii.screen.favorites.ui.success

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.favorites.R
import ru.pokrovskii.screen.favorites.ui.state.FavoritesScreenState
import ru.pokrovskii.screen.favorites.viewmodel.FavoritesScreenPresenter
import ru.pokrovskii.song.item.api.ui.SongItemWrapper

@Composable
internal fun FavoritesScreenSuccess(
    state: FavoritesScreenState.Success,
    presenter: FavoritesScreenPresenter,
) {

    val songs = state.songs
    if (songs.isEmpty()) {
        return EmptyState()
    }

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        text = stringResource(R.string.your_favorites),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground,
    )

    LazyColumn {
        items(
            items = songs,
            key = { item -> item.model.id },
        ) { song ->
            val songItemPresenter = presenter.createSongItemPresenter(songItem = song.model)
            SongItemWrapper(
                model = song.uiModel,
                presenter = songItemPresenter,
                modifier = Modifier
                    .animateItem(),
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
            text = stringResource(R.string.favorites_empty_state),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )
    }
}