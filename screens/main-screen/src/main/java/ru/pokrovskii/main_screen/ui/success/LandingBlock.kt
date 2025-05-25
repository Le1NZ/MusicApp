package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.main_screen.R
import ru.pokrovskii.main_screen.state.LandingBlockState
import ru.pokrovskii.main_screen.state.LandingSongState
import ru.pokrovskii.main_screen.ui.edit.AddBottomSheet
import ru.pokrovskii.main_screen.ui.edit.EditTitleBottomSheet
import ru.pokrovskii.main_screen.ui.edit.canEdit
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenter
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenterPreview

@Composable
internal fun LandingBlock(
    block: LandingBlockState,
    presenter: MainScreenPresenter,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        BlockTitle(
            name = block.title,
            onEdit = { presenter.onBlockTitleChanged(id = block.id, newTitle = it) },
        )

        LandingBlockHorizontalPager(
            blockId = block.id,
            songs = block.songs,
            presenter = presenter,
        )
    }
}

@Composable
private fun BlockTitle(
    name: String,
    onEdit: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showEditBottomSheet by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 8.dp),
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        if (canEdit) {
            IconButton(
                modifier = Modifier
                    .wrapContentSize(),
                onClick = { showEditBottomSheet = true },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_edit_24),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }

    if (showEditBottomSheet) {
        EditTitleBottomSheet(
            currentTitle = name,
            onEdit = onEdit,
            onDismiss = { showEditBottomSheet = false },
        )
    }
}

@Composable
private fun LandingBlockHorizontalPager(
    blockId: String,
    songs: List<LandingSongState>,
    presenter: MainScreenPresenter,
    modifier: Modifier = Modifier,
) {
    var showAddBottomSheet by remember { mutableStateOf(false) }

    val state = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { songs.size },
    )

    HorizontalPager(
        modifier = modifier,
        state = state,
        pageSpacing = 8.dp,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
        ),
        key = { songs[it].id },
    ) { page ->
        when (val song = songs[page]) {
            is LandingSongState.Song -> LandingBlockSong(
                song = song,
                onClick = presenter::onSongClick,
                onSongDelete = { presenter.onSongDelete(id = it, blockId = blockId) },
            )

            is LandingSongState.Add -> AddLandingBlockSong(
                onClick = { showAddBottomSheet = true },
            )
        }
    }

    if (showAddBottomSheet) {
        AddBottomSheet(
            onAdd = { id, title, artist, imageUrl ->
                presenter.onSongAdd(
                    id = id,
                    title = title,
                    artist = artist,
                    imageUrl = imageUrl,
                    blockId = blockId,
                )
            },
            onDismiss = { showAddBottomSheet = false },
        )
    }
}

@Preview
@Composable
private fun SkeletonBlockPreview() {
    AppTheme {
        Surface {
            LandingBlock(
                block = LandingBlockState.forPreview(1),
                presenter = MainScreenPresenterPreview(),
            )
        }
    }
}