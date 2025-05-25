package ru.pokrovskii.screen.song.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

internal val LocalCanCopy = compositionLocalOf {
    false
}

internal val canCopy: Boolean
    @Composable
    @ReadOnlyComposable
    get() = LocalCanCopy.current