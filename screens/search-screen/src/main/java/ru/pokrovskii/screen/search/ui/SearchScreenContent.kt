package ru.pokrovskii.screen.search.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pokrovskii.design.screen.ErrorScreen
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.design.search.SearchField
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.screen.search.R
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.ui.success.SearchScreenSuccess
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenterPreview

@Composable
internal fun SearchScreenContent(
    state: SearchScreenState,
    presenter: SearchScreenPresenter,
) {
    val query by presenter.query.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = listOf(
                    ToolbarIcon.Favorites(presenter::onFavoritesClick),
                )
            )
        )

        SearchField(
            query = query,
            onQueryChanged = presenter::onQueryChanged,
            placeholderText = stringResource(R.string.enter_query),
        )

        Box(
            modifier = Modifier
                .imePadding()
                .fillMaxSize(),
        ) {
            when (state) {
                is SearchScreenState.Loading -> LoadingScreen()

                is SearchScreenState.Error -> ErrorScreen(
                    onRetryClick = presenter::onRetryClick,
                )

                is SearchScreenState.Success -> SearchScreenSuccess(
                    state = state,
                    presenter = presenter,
                )
            }
        }
    }
}

@Composable
@Preview
private fun SearchScreenContentPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxHeight(),
        ) {
            SearchScreenContent(
                state = SearchScreenState.forPreview(),
                presenter = SearchScreenPresenterPreview(),
            )
        }
    }
}