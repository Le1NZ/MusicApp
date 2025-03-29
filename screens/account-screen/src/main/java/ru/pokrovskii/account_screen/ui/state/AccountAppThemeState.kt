package ru.pokrovskii.account_screen.ui.state

internal sealed interface AccountAppThemeState {

    data object Light : AccountAppThemeState
    data object Dark : AccountAppThemeState
    data object System : AccountAppThemeState

    companion object {

        val themeList = listOf(System, Light, Dark)

        fun forPreview(): AccountAppThemeState {
            return System
        }
    }
}