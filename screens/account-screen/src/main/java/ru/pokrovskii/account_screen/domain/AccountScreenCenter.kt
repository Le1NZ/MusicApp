package ru.pokrovskii.account_screen.domain

import ru.pokrovskii.design.theme.api.AppThemeInteractor
import ru.pokrovskii.design.theme.api.AppThemeState

internal class AccountScreenCenter(
    private val appThemeInteractor: AppThemeInteractor,
) {
    val themeState = appThemeInteractor.currentState

    suspend fun setNewState(newState: AppThemeState) {
        appThemeInteractor.setState(
            newState = newState,
        )
    }
}