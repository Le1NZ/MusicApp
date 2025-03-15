package ru.pokrovskii.screen.search.ui.success

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.pokrovskii.screen.search.ui.state.SearchScreenState
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenter

@Composable
internal fun SearchScreenSuccess(
    state: SearchScreenState.Success,
    presenter: SearchScreenPresenter,
    modifier: Modifier = Modifier,
) {
    when (state) {
        is SearchScreenState.Success.History -> SearchScreenHistory(
            state = state,
            presenter = presenter,
            modifier = modifier,
        )

        is SearchScreenState.Success.Result -> SearchScreenResults(
            state = state,
            presenter = presenter,
            modifier = modifier,
        )
    }
}
