package ru.pokrovskii.main_screen.ui.edit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

internal val LocalCanEdit = compositionLocalOf {
    false
}

internal val canEdit: Boolean
    @Composable
    @ReadOnlyComposable
    get() = LocalCanEdit.current