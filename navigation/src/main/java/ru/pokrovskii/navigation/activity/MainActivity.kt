package ru.pokrovskii.navigation.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import ru.pokrovskii.design.theme.api.AppThemeInteractor
import ru.pokrovskii.design.theme.api.AppThemeState
import ru.pokrovskii.navigation.R


internal class MainActivity : AppCompatActivity() {

    private val themeInteractor by inject<AppThemeInteractor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        collectWindowInsetsColor()
        setContentView(R.layout.activity_main)
    }

    private fun collectWindowInsetsColor() {
        val insetsController = WindowInsetsControllerCompat(window, window.decorView)

        lifecycleScope.launch {
            themeInteractor.currentState.collect { theme ->
                if (isDarkTheme(theme)) {
                    insetsController.isAppearanceLightStatusBars = false
                    insetsController.isAppearanceLightNavigationBars = false
                } else {
                    insetsController.isAppearanceLightStatusBars = true
                    insetsController.isAppearanceLightNavigationBars = true
                }
            }
        }
    }

    private fun isDarkTheme(themeState: AppThemeState): Boolean {
        return when (themeState) {
            AppThemeState.DARK -> true
            AppThemeState.LIGHT -> false
            AppThemeState.SYSTEM -> isSystemInDarkThemeCompat()
        }
    }

    private fun isSystemInDarkThemeCompat(): Boolean {
        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES
    }
}
