package ru.pokrovskii.sign_up_screen.ui.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface SignUpScreenEvent {

    data object SignUpFailed : SignUpScreenEvent
    data object SignUpSuccess : SignUpScreenEvent
    data object PasswordsNotMatches : SignUpScreenEvent
}