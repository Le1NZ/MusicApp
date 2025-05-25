package ru.pokrovskii.navigation.activity

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.design.theme.api.AppThemeInteractor
import ru.pokrovskii.design.theme.api.AppThemeState
import ru.pokrovskii.model.auth.isAuthorized
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.R
import ru.pokrovskii.navigation.api.NavigationComponent

internal class MainActivity : AppCompatActivity() {

    private val themeInteractor by inject<AppThemeInteractor>()
    private val userCenter by inject<UserCenter>()
    private val router by lazy {
        get<NavigationComponent>().createRouter(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        collectWindowInsetsColor()
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val isAuthorized = userCenter.currentUserBlocking().isAuthorized()
            val pendingScreen = if (isAuthorized) {
                Screen.Landing
            } else {
                Screen.Login
            }

            router.openScreen(screen = pendingScreen)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
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
