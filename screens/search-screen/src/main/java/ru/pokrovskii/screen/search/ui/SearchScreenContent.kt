package ru.pokrovskii.screen.search.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.screen.search.R
import ru.pokrovskii.design.screen.ErrorScreen
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.ui.success.SearchScreenSuccess
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenterPreview
import ru.pokrovskii.design.R.drawable

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

        TextField(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            value = query,
            onValueChange = presenter::onQueryChanged,
            placeholder = { Text(text = stringResource(R.string.enter_query)) },
            trailingIcon = {
                if (query.isNotEmpty()) {
                    IconButton(
                        onClick = { presenter.onQueryChanged("") },
                    ) {
                        Icon(
                            painter = painterResource(id = drawable.ic_close_24),
                            contentDescription = null,
                        )
                    }
                }
            }
        )

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

@Composable
@Preview
private fun SearchScreenContentPreview() {
    AppTheme {
        Surface {
            SearchScreenContent(
                state = SearchScreenState.Loading,
                presenter = SearchScreenPresenterPreview(),
            )
        }
    }
}