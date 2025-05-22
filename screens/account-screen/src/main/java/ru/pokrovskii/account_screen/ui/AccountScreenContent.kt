package ru.pokrovskii.account_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.pokrovskii.account_screen.ui.state.AccountScreenEvent
import ru.pokrovskii.account_screen.ui.state.AccountScreenState
import ru.pokrovskii.account_screen.ui.success.AccountScreenSuccess
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenter
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenterPreview
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.design.utils.showToast

@Composable
internal fun AccountScreenContent(
    presenter: AccountScreenPresenter,
    state: AccountScreenState,
) {
    CollectEvents(presenter)

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

@Composable
private fun CollectEvents(
    presenter: AccountScreenPresenter,
) {
    LaunchedEffect(Unit) {
        presenter.events.collect { event ->
            when (event) {
                is AccountScreenEvent.LogoutSuccess -> presenter.onSuccessLogout()
            }
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