package ru.pokrovskii.main_screen.ui.success

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.toolbar.ToolbarIcon
import ru.pokrovskii.main_screen.R
import ru.pokrovskii.main_screen.state.MainScreenState
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenter
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenterPreview

@Composable
internal fun MainScreenSuccess(
    state: MainScreenState.Success,
    presenter: MainScreenPresenter,
) {
    Column(
        modifier = Modifier
            .statusBarsPadding(),
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = listOf(
                    ToolbarIcon.Favorites(
                        onClick = presenter::onFavoritesClick,
                    ),
                    ToolbarIcon.Search(
                        onClick = presenter::onSearchClick,
                    ),
                ),
            )
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(
                items = state.blocks,
                key = { it.id },
            ) { block ->
                LandingBlock(
                    block = block,
                    presenter = presenter,
                )
            }

            item {
                Button(
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = presenter::onBlockAdd,
                ) {
                    Text(
                        text = stringResource(R.string.add_block),
                        color = MaterialTheme.colorScheme.onSecondary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.navigationBarsPadding())
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenSuccessPreview() {
    AppTheme {
        Surface {
            MainScreenSuccess(
                state = MainScreenState.forPreview(),
                presenter = MainScreenPresenterPreview(),
            )
        }
    }
}