package ru.pokrovskii.design.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun BottomOverlay(
    modifier: Modifier,
    height: Dp,
) {
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    0f to Color.Unspecified,
                    .1f to MaterialTheme.colorScheme.background.copy(0.5f),
                    .15f to MaterialTheme.colorScheme.background.copy(0.7f),
                    .2f to MaterialTheme.colorScheme.background.copy(0.8f),
                    .3f to MaterialTheme.colorScheme.background.copy(0.85f),
                    .4f to MaterialTheme.colorScheme.background.copy(0.9f),
                    .5f to MaterialTheme.colorScheme.background.copy(0.95f),
                    .6f to MaterialTheme.colorScheme.background.copy(0.98f),
                    1f to MaterialTheme.colorScheme.background,
                )
            ),
    )
}
