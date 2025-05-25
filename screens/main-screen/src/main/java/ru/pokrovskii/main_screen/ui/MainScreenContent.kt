package ru.pokrovskii.main_screen.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pokrovskii.design.screen.ErrorScreen
import ru.pokrovskii.design.screen.LoadingScreen
import ru.pokrovskii.main_screen.state.MainScreenState
import ru.pokrovskii.main_screen.ui.edit.LocalCanEdit
import ru.pokrovskii.main_screen.ui.success.MainScreenSuccess
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenter

@Composable
internal fun MainScreenContent(
    presenter: MainScreenPresenter,
) {
    when (val state = presenter.state.collectAsStateWithLifecycle().value) {
        is MainScreenState.Loading -> LoadingScreen()

        is MainScreenState.Error -> ErrorScreen(
            onRetryClick = presenter::onRetryClick,
        )

        is MainScreenState.Success -> CompositionLocalProvider(
            value = LocalCanEdit provides presenter.canEdit.collectAsStateWithLifecycle().value,
        ) {
            MainScreenSuccess(
                state = state,
                presenter = presenter,
            )
        }
    }
}