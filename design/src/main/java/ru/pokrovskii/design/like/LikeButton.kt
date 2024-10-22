package ru.pokrovskii.design.like

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.pokrovskii.design.R

@Composable
fun LikeButton(
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AnimatedContent(
        targetState = isLiked,
        modifier = modifier
            .clip(CircleShape)
            .clickable(onClick = onLikeClick)
            .background(MaterialTheme.colorScheme.surfaceTint)
            .size(40.dp)
            .padding(8.dp),
        label = "Like button",
    ) { isCurrentLiked ->
        val (iconId, color) = if (isCurrentLiked) {
            R.drawable.ic_favorites_filled_24 to MaterialTheme.colorScheme.onError
        } else {
            R.drawable.ic_favorites_24 to MaterialTheme.colorScheme.inverseOnSurface
        }

        Icon(
            modifier = Modifier
                .size(24.dp),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = color,
        )
    }
}