package ru.pokrovskii.account_screen.ui.mapper

import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState
import ru.pokrovskii.design.theme.api.AppThemeState

internal object AccountAppThemeStateConverter {

    fun convert(appThemeState: AppThemeState): AccountAppThemeState {
        return when (appThemeState) {
            AppThemeState.SYSTEM -> AccountAppThemeState.System
            AppThemeState.DARK -> AccountAppThemeState.Dark
            AppThemeState.LIGHT -> AccountAppThemeState.Light
        }
    }

    fun convert(appThemeState: AccountAppThemeState): AppThemeState {
        return when (appThemeState) {
            is AccountAppThemeState.System -> AppThemeState.SYSTEM
            is AccountAppThemeState.Dark -> AppThemeState.DARK
            is AccountAppThemeState.Light -> AppThemeState.LIGHT
        }
    }
}