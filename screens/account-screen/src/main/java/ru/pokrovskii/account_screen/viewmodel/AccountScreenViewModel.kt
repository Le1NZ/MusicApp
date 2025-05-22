package ru.pokrovskii.account_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.pokrovskii.account_screen.domain.AccountScreenCenter
import ru.pokrovskii.account_screen.ui.mapper.AccountAppThemeStateConverter
import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState
import ru.pokrovskii.account_screen.ui.state.AccountScreenEvent
import ru.pokrovskii.account_screen.ui.state.AccountScreenState
import ru.pokrovskii.auth.api.UserCenter

internal class AccountScreenViewModel(
    private val center: AccountScreenCenter,
    userCenterLazy: Lazy<UserCenter>,
) : ViewModel() {

    private val userCenter by userCenterLazy

    private var switchThemeJob: Job? = null

    private val _isLogoutInProgress = MutableStateFlow(false)
    val isLogoutInProgress: StateFlow<Boolean> = _isLogoutInProgress

    private val _events = MutableSharedFlow<AccountScreenEvent>()
    val events: SharedFlow<AccountScreenEvent> = _events

    val state = center.themeState.map { themeState ->
        AccountScreenState.Success(
            theme = AccountAppThemeStateConverter.convert(
                appThemeState = themeState,
            )
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = AccountScreenState.Success(
            theme = AccountAppThemeStateConverter.convert(
                appThemeState = center.themeState.value,
            ),
        ),
    )

    fun switchTheme(newTheme: AccountAppThemeState) {
        switchThemeJob?.cancel()
        switchThemeJob = viewModelScope.launch {
            center.setNewState(
                newState = AccountAppThemeStateConverter.convert(
                    appThemeState = newTheme,
                ),
            )
        }
    }

    fun logout() {
        _isLogoutInProgress.value = true

        viewModelScope.launch {
            userCenter.logout()

            _events.emit(AccountScreenEvent.LogoutSuccess)
            _isLogoutInProgress.value = false
        }
    }
}