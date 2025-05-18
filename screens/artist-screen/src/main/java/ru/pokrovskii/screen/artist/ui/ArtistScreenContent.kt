package ru.pokrovskii.screen.artist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
import ru.pokrovskii.screen.artist.ui.state.ArtistScreenState
import ru.pokrovskii.screen.artist.ui.success.ArtistScreenSuccess
import ru.pokrovskii.screen.artist.viewmodel.ArtistScreenPresenter
import ru.pokrovskii.screen.artist.viewmodel.ArtistScreenPresenterPreview

@Composable
internal fun ArtistScreenContent(
    presenter: ArtistScreenPresenter,
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

        when (val state = presenter.state.collectAsStateWithLifecycle().value) {
            is ArtistScreenState.Loading -> LoadingScreen()
            is ArtistScreenState.Error -> ErrorScreen(
                onRetryClick = presenter::onRetryClick,
            )

            is ArtistScreenState.Success -> ArtistScreenSuccess(
                state = state,
                presenter = presenter,
            )
        }
    }
}

@Preview
@Composable
private fun ArtistScreenContentPreview() {
    AppTheme {
        Surface {
            ArtistScreenContent(
                presenter = ArtistScreenPresenterPreview(),
            )
        }
    }
}