package ru.pokrovskii.screen.song.ui.success

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.screen.song.ui.state.SongScreenState
import ru.pokrovskii.screen.song.ui.state.SongUiModel
import ru.pokrovskii.screen.song.ui.success.artist.FeaturedArtistsBlock
import ru.pokrovskii.screen.song.ui.success.artist.PrimaryArtistsBlock
import ru.pokrovskii.screen.song.ui.success.artist.ProducerArtistsBlock
import ru.pokrovskii.screen.song.ui.success.block.SongHotBlock
import ru.pokrovskii.screen.song.ui.success.block.SongRecordingLocation
import ru.pokrovskii.screen.song.ui.success.block.SongReleaseDate
import ru.pokrovskii.screen.song.ui.success.block.SongToTextButton
import ru.pokrovskii.screen.song.ui.success.header.SongHeader

@Composable
internal fun SongScreenSuccess(
    state: SongScreenState.Success,
    onLikeClick: () -> Unit,
    onToTextButtonClick: () -> Unit,
) {
    val song = state.songUiModel

    LazyColumn {
        item {
            SongHeader(
                songUiModel = song,
                onLikeClick = onLikeClick,
            )
        }

        item {
            SongHotBlock(
                modifier = Modifier
                    .padding(vertical = 8.dp),
            )
        }
        item {
            PrimaryArtistsBlock(
                modifier = Modifier
                    .padding(top = 4.dp),
                primaryArtists = song.artists
            )
        }
        item {
            FeaturedArtistsBlock(
                modifier = Modifier
                    .padding(top = 4.dp),
                featuredArtists = song.featuredArtists,
            )
        }
        item {
            SongReleaseDate(
                modifier = Modifier
                    .padding(top = 4.dp),
                releaseDate = song.releaseDate,
            )
        }
        item {
            SongRecordingLocation(
                modifier = Modifier
                    .padding(vertical = 4.dp),
                recordingLocation = song.recordingLocation,
            )
        }
        item {
            SongToTextButton(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                onClick = onToTextButtonClick,
            )
        }


        item {
            ProducerArtistsBlock(
                modifier = Modifier
                    .padding(top = 4.dp),
                producerArtists = song.producers,
            )
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
                onLikeClick = {},
                onToTextButtonClick = {},
            )
        }
    }
}