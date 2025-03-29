package ru.pokrovskii.account_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.pokrovskii.account_screen.domain.AccountScreenCenter
import ru.pokrovskii.account_screen.ui.mapper.AccountAppThemeStateConverter
import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState
import ru.pokrovskii.account_screen.ui.state.AccountScreenState

internal class AccountScreenViewModel(
    private val center: AccountScreenCenter,
) : ViewModel() {

    private var switchThemeJob: Job? = null

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
}