package ru.pokrovskii.design.modifier

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Stable
fun Modifier.alpha(alpha: () -> Float): Modifier {
    return graphicsLayer {
        this.alpha = alpha()
    }
}