package ru.pokrovskii.screen.artist.ui.success

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.pokrovskii.screen.artist.ui.state.ArtistScreenState
import ru.pokrovskii.screen.artist.ui.success.block.ArtistAkaBlock
import ru.pokrovskii.screen.artist.ui.success.block.ArtistToAllSongsBlock
import ru.pokrovskii.screen.artist.ui.success.header.ArtistHeader
import ru.pokrovskii.screen.artist.viewmodel.ArtistScreenPresenter

@Composable
internal fun ArtistScreenSuccess(
    state: ArtistScreenState.Success,
    presenter: ArtistScreenPresenter,
    modifier: Modifier = Modifier,
) {
    val artist = remember(state) { state.artist }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
        modifier = modifier,
    ) {
        item {
            ArtistHeader(
                artist = artist,
                lazyListState = lazyListState,
            )
        }

        artist.aka?.let {
            item {
                ArtistAkaBlock(
                    akaList = it,
                    modifier = Modifier
                        .padding(top = 16.dp),
                )
            }
        }

        item {
            ArtistToAllSongsBlock(
                onClick = presenter::onAllSongsClick,
                modifier = Modifier
                    .padding(top = 16.dp),
            )
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}