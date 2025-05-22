package ru.pokrovskii.account_screen.viewmodel

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.account_screen.api.AccountScreenActions
import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState
import ru.pokrovskii.account_screen.ui.state.AccountScreenEvent

internal interface AccountScreenPresenter {

    val isLogoutInProgress: StateFlow<Boolean>

    val events: SharedFlow<AccountScreenEvent>

    fun onFavoritesClick()
    fun onSearchClick()
    fun switchTheme(appTheme: AccountAppThemeState)
    fun logout()
    fun onSuccessLogout()
}

internal class AccountScreenPresenterImpl(
    private val viewModel: AccountScreenViewModel,
    private val actions: AccountScreenActions,
) : AccountScreenPresenter {

    override val isLogoutInProgress = viewModel.isLogoutInProgress
    override val events = viewModel.events

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

    override fun logout() {
        viewModel.logout()
    }

    override fun onSuccessLogout() {
        actions.onLogout()
    }
}

internal class AccountScreenPresenterPreview : AccountScreenPresenter {

    override val isLogoutInProgress = MutableStateFlow(false)
    override val events = MutableSharedFlow<AccountScreenEvent>()

    override fun onFavoritesClick() = Unit
    override fun onSearchClick() = Unit
    override fun switchTheme(appTheme: AccountAppThemeState) = Unit
    override fun logout() = Unit
    override fun onSuccessLogout() = Unit
}