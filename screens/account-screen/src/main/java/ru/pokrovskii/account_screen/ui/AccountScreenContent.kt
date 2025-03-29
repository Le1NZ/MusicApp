package ru.pokrovskii.account_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.pokrovskii.account_screen.ui.state.AccountScreenState
import ru.pokrovskii.account_screen.ui.success.AccountScreenSuccess
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenter
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenterPreview
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon

@Composable
internal fun AccountScreenContent(
    presenter: AccountScreenPresenter,
    state: AccountScreenState,
) {
    Column(
        modifier = Modifier
            .statusBarsPadding(),
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = listOf(
                    ToolbarIcon.Favorites(
                        onClick = presenter::onFavoritesClick,
                    ),
                    ToolbarIcon.Search(
                        onClick = presenter::onSearchClick,
                    ),
                ),
            )
        )

        when (state) {
            is AccountScreenState.Loading -> LoadingScreen()

            is AccountScreenState.Success -> AccountScreenSuccess(
                presenter = presenter,
                state = state,
            )
        }
    }
}

@Preview
@Composable
private fun AccountScreenContentPreview() {
    AppTheme {
        Surface {
            AccountScreenContent(
                presenter = AccountScreenPresenterPreview(),
                state = AccountScreenState.forPreview(),
            )
        }
    }
}