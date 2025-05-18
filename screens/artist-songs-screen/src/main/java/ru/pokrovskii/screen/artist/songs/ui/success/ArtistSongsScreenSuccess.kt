package ru.pokrovskii.screen.artist.songs.ui.success

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.screen.artist.songs.R
import ru.pokrovskii.screen.artist.songs.ui.state.ArtistSongsScreenState
import ru.pokrovskii.screen.artist.songs.viewmodel.ArtistSongsScreenPresenter
import ru.pokrovskii.song.item.api.ui.SongItemWrapper

@Composable
internal fun ArtistSongsScreenSuccess(
    state: ArtistSongsScreenState.Success,
    presenter: ArtistSongsScreenPresenter,
) {
    val songs = remember(state) { state.songs }
    if (songs.isEmpty()) {
        return EmptyState()
    }

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        text = state.artistName,
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
            text = stringResource(R.string.no_songs),
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
        )
    }
}