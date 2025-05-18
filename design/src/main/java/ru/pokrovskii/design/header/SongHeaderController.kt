package ru.pokrovskii.design.header

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Stable
internal class HeaderOverlayAlphaController(
    private val lazyListState: LazyListState,
    private val headerPosition: Int,
) {

    val coverOverlayAlpha: Float
        get() {
            if (lazyListState.firstVisibleItemIndex > headerPosition) {
                return 0f
            }

            if (lazyListState.layoutInfo.visibleItemsInfo.isEmpty()) {
                return 1f
            }

            val headerItemInfo = lazyListState.layoutInfo.visibleItemsInfo.getOrNull(headerPosition) ?: return 0f

            val currentBottomHeaderPosition = (headerItemInfo.offset + headerItemInfo.size).toFloat()
            val initialBottomHeaderPosition = currentBottomHeaderPosition + lazyListState.firstVisibleItemScrollOffset
            val headerOffset = currentBottomHeaderPosition.coerceIn(0f, initialBottomHeaderPosition)

            return headerOffset / initialBottomHeaderPosition
        }
}

@Composable
internal fun rememberOverlayAlphaController(
    lazyListState: LazyListState,
    headerPosition: Int = 0,
): HeaderOverlayAlphaController {
    return remember {
        HeaderOverlayAlphaController(lazyListState, headerPosition)
    }
}