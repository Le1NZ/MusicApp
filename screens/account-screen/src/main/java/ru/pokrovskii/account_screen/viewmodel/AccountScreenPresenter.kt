package ru.pokrovskii.account_screen.viewmodel

import ru.pokrovskii.account_screen.api.AccountScreenActions
import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState

internal interface AccountScreenPresenter {

    fun onFavoritesClick()
    fun onSearchClick()
    fun switchTheme(appTheme: AccountAppThemeState)
}

internal class AccountScreenPresenterImpl(
    private val viewModel: AccountScreenViewModel,
    private val actions: AccountScreenActions,
) : AccountScreenPresenter {

    override fun onFavoritesClick() {
        actions.onFavoritesClick()
    }

    override fun onSearchClick() {
        actions.onSearchClick()
    }

    override fun switchTheme(appTheme: AccountAppThemeState) {
        viewModel.switchTheme(
            newTheme = appTheme,
        )
    }
}

internal class AccountScreenPresenterPreview : AccountScreenPresenter {

    override fun onFavoritesClick() = Unit
    override fun onSearchClick() = Unit
    override fun switchTheme(appTheme: AccountAppThemeState) = Unit
}