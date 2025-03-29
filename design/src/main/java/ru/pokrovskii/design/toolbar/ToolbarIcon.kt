package ru.pokrovskii.design.toolbar

import androidx.compose.runtime.Immutable
import ru.pokrovskii.design.R

@Immutable
sealed interface ToolbarIcon {

    val iconRes: Int
    val onClick: () -> Unit

    data class Search(
        override val onClick: () -> Unit,
    ) : ToolbarIcon {

        override val iconRes = R.drawable.ic_search_24
    }

    data class Favorites(
        override val onClick: () -> Unit,
    ) : ToolbarIcon {

        override val iconRes = R.drawable.ic_favorites_24
    }

    data class Account(
        override val onClick: () -> Unit,
    ) : ToolbarIcon {

        override val iconRes = R.drawable.ic_account_24
    }
}