package ru.pokrovskii.log_in_screen.ui.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface LoginScreenEvent {

    data object LoginFailed : LoginScreenEvent
    data object LoginSuccess : LoginScreenEvent
}