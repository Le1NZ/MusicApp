package ru.pokrovskii.screen.favorites.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.screen.favorites.ui.state.FavoritesScreenState
import ru.pokrovskii.screen.favorites.ui.success.FavoritesScreenSuccess
import ru.pokrovskii.screen.favorites.viewmodel.FavoritesScreenPresenter
import ru.pokrovskii.screen.favorites.viewmodel.FavoritesScreenPresenterPreview

@Composable
internal fun FavoritesScreenContent(
    state: FavoritesScreenState,
    presenter: FavoritesScreenPresenter,
) {
    Column {
        AppToolbar(
            config = ToolbarConfig(
                listOf(
                    ToolbarIcon.Search(presenter::onSearchClick),
                )
            )
        )

        when (state) {
            is FavoritesScreenState.Loading -> LoadingScreen()
            is FavoritesScreenState.Success -> FavoritesScreenSuccess(
                state = state,
                onSongClick = presenter::onSongClick,
            )
        }
    }
}

@Composable
@Preview
private fun FavoritesScreenContentPreview() {
    AppTheme {
        Surface {
            FavoritesScreenContent(
                state = FavoritesScreenState.Loading,
                presenter = FavoritesScreenPresenterPreview(),
            )
        }
    }
}