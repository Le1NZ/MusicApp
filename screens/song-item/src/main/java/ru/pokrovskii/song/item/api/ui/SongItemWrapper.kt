package ru.pokrovskii.song.item.api.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.pokrovskii.song.item.api.model.SongItemUiModel
import ru.pokrovskii.song.item.ui.SongItem

@Composable
fun SongItemWrapper(
    model: SongItemUiModel,
    presenter: SongItemPresenter,
    modifier: Modifier = Modifier,
) {
    SongItem(
        model = model,
        modifier = modifier,
        presenter = presenter,
    )
}