package ru.pokrovskii.screen.song.ui.success

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.screen.song.ui.state.SongScreenState
import ru.pokrovskii.screen.song.ui.state.SongUiModel
import ru.pokrovskii.screen.song.ui.success.artist.FeaturedArtistsBlock
import ru.pokrovskii.screen.song.ui.success.artist.PrimaryArtistsBlock
import ru.pokrovskii.screen.song.ui.success.artist.ProducerArtistsBlock
import ru.pokrovskii.screen.song.ui.success.block.AlbumBlock
import ru.pokrovskii.screen.song.ui.success.block.SongHotBlock
import ru.pokrovskii.screen.song.ui.success.block.SongRecordingLocation
import ru.pokrovskii.screen.song.ui.success.block.SongReleaseDate
import ru.pokrovskii.screen.song.ui.success.block.SongToTextButton
import ru.pokrovskii.screen.song.ui.success.header.SongHeader
import ru.pokrovskii.screen.song.viewmodel.SongScreenPresenter
import ru.pokrovskii.screen.song.viewmodel.SongScreenPresenterPreview

@Composable
internal fun SongScreenSuccess(
    state: SongScreenState.Success,
    presenter: SongScreenPresenter,
    onToTextButtonClick: () -> Unit,
) {
    val song = remember(state) { state.songUiModel }
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState,
    ) {
        item {
            SongHeader(
                songUiModel = song,
                onLikeClick = presenter::onLikeClick,
                lazyListState = lazyListState,
            )
        }

        if (song.isHot) {
            item {
                SongHotBlock(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                )
            }
        }
        item {
            PrimaryArtistsBlock(
                modifier = Modifier
                    .padding(top = 16.dp),
                primaryArtists = song.artists,
                onArtistClick = presenter::onArtistClick,
            )
        }
        song.featuredArtists?.let { featuredArtists ->
            item {
                FeaturedArtistsBlock(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    featuredArtists = featuredArtists,
                    onArtistClick = presenter::onArtistClick,
                )
            }
        }
        song.album?.let { album ->
            item {
                AlbumBlock(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    album = album
                )
            }
        }
        song.releaseDate?.let { releaseDate ->
            item {
                SongReleaseDate(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    releaseDate = releaseDate,
                )
            }
        }
        song.recordingLocation?.let { recordingLocation ->
            item {
                SongRecordingLocation(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    recordingLocation = recordingLocation,
                )
            }
        }
        item {
            SongToTextButton(
                modifier = Modifier
                    .padding(top = 8.dp),
                onClick = onToTextButtonClick,
            )
        }
        song.producers?.let { producers ->
            item {
                ProducerArtistsBlock(
                    modifier = Modifier
                        .padding(top = 16.dp),
                    producerArtists = producers,
                    onArtistClick = presenter::onArtistClick,
                )
            }
        }
        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}

@Composable
@Preview
private fun SongScreenSuccessPreview() {
    AppTheme {
        Surface {
            SongScreenSuccess(
                state = SongScreenState.Success(
                    songUiModel = SongUiModel.PREVIEW,
                ),
                presenter = SongScreenPresenterPreview(),
                onToTextButtonClick = {},
            )
        }
    }
}