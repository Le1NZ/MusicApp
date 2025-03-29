package ru.pokrovskii.design.theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import ru.pokrovskii.design.theme.api.AppThemeInteractor
import ru.pokrovskii.design.theme.api.AppThemeState

internal class AppThemeInteractorImpl(
    private val storage: AppThemeStorage,
) : AppThemeInteractor {

    override val currentState = MutableStateFlow(loadThemeState())

    override suspend fun setState(newState: AppThemeState) {
        currentState.value = newState
        storage.setState(
            state = newState,
        )
    }

    private fun loadThemeState(): AppThemeState {
        // Very need to load right theme
        return runBlocking {
            storage.state.first()
        }
    }
}