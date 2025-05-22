package ru.pokrovskii.account_screen.ui.state

import androidx.compose.runtime.Immutable

@Immutable
sealed interface AccountScreenEvent {

    data object LogoutSuccess : AccountScreenEvent
}