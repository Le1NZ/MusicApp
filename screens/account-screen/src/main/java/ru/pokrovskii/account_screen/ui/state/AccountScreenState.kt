package ru.pokrovskii.account_screen.ui.state

internal interface AccountScreenState {

    val theme: AccountAppThemeState

    data class Loading(
        override val theme: AccountAppThemeState,
    ) : AccountScreenState

    data class Success(
        override val theme: AccountAppThemeState,
    ) : AccountScreenState

    companion object {

        fun forPreview(): Success {
            return Success(
                theme = AccountAppThemeState.forPreview(),
            )
        }
    }
}
