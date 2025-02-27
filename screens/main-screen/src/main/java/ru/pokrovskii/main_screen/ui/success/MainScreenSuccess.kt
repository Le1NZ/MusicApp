package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.main_screen.state.SkeletonSongState

@Composable
internal fun MainScreenSuccess(

) {
    Column(
        modifier = Modifier
            .statusBarsPadding(),
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = listOf(
                    ToolbarIcon.Favorites(
                        onClick = { },
                    ),
                    ToolbarIcon.Search(
                        onClick = { },
                    ),
                ),
            )
        )

        SkeletonBlock(
            name = "Новое",
            songs = listOf(
                SkeletonSongState.forPreview(),
                SkeletonSongState.forPreview(),
            ),
        )

        SkeletonBlock(
            modifier = Modifier
                .padding(top = 16.dp),
            name = "Интересное",
            songs = listOf(
                SkeletonSongState.forPreview(),
                SkeletonSongState.forPreview(),
            )
        )

        SkeletonBlock(
            modifier = Modifier
                .padding(top = 16.dp),
            name = "Лучшее",
            songs = listOf(
                SkeletonSongState.forPreview(),
                SkeletonSongState.forPreview(),
            )
        )

        Spacer(modifier = Modifier.navigationBarsPadding())
    }
}

@Preview
@Composable
private fun MainScreenSuccessPreview() {
    AppTheme {
        Surface {
            MainScreenSuccess()
        }
    }
}