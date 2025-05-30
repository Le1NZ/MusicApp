package ru.pokrovskii.screen.song.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pokrovskii.design.screen.ErrorScreen
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.screen.song.ui.state.SongScreenState
import ru.pokrovskii.screen.song.ui.success.SongScreenSuccess
import ru.pokrovskii.screen.song.viewmodel.SongScreenPresenter
import ru.pokrovskii.screen.song.viewmodel.SongScreenPresenterPreview

@Composable
internal fun SongScreenContent(
    state: SongScreenState,
    presenter: SongScreenPresenter,
) {
    Column(
        modifier = Modifier
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = listOf(
                    ToolbarIcon.Favorites(presenter::onFavoritesClick),
                    ToolbarIcon.Search(presenter::onSearchClick),
                )
            )
        )

        when (state) {
            is SongScreenState.Loading -> LoadingScreen()
            is SongScreenState.Error -> ErrorScreen(
                onRetryClick = presenter::onRetryClick,
            )
            is SongScreenState.Success -> CompositionLocalProvider(
                value = LocalCanCopy provides presenter.canCopy.collectAsStateWithLifecycle().value,
            ) {
                SongScreenSuccess(
                    state = state,
                    presenter = presenter,
                    onToTextButtonClick = presenter::onToTextButtonClick,
                )
            }
        }
    }
}

@Composable
@Preview
private fun SongScreenContentPreview() {
    AppTheme {
        Surface {
            SongScreenContent(
                state = SongScreenState.forPreview(),
                presenter = SongScreenPresenterPreview(),
            )
        }
    }
}