package ru.pokrovskii.design.modifier

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

/**
 * Modifier that creates parallax effect
 * @param state lazy list state
 * @param rate coefficient that defines how faster this element than others
 */
@Stable
fun Modifier.parallaxEffect(state: LazyListState, rate: Float) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val scrollOffset = (state.firstVisibleItemScrollOffset / rate).toInt()
        layout(placeable.width, placeable.height) {
            placeable.place(0, scrollOffset)
        }
    }