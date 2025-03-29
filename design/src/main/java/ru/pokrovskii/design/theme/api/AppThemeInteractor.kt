package ru.pokrovskii.design.theme.api

import kotlinx.coroutines.flow.StateFlow

interface AppThemeInteractor {

    val currentState: StateFlow<AppThemeState>

    suspend fun setState(newState: AppThemeState)
}