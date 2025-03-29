package ru.pokrovskii.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.java.KoinJavaComponent.inject
import ru.pokrovskii.design.theme.api.AppThemeInteractor
import ru.pokrovskii.design.theme.api.AppThemeState

internal object AppThemeController {

    private val interactor by inject<AppThemeInteractor>(AppThemeInteractor::class.java)

    @Composable
    fun isAppInDarkTheme(): Boolean {
        val theme by interactor.currentState.collectAsState()

        return when (theme) {
            AppThemeState.DARK -> true
            AppThemeState.LIGHT -> false
            AppThemeState.SYSTEM -> isSystemInDarkTheme()
        }
    }
}
