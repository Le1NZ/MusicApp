package ru.pokrovskii.account_screen.ui.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.account_screen.R
import ru.pokrovskii.account_screen.ui.state.AccountScreenState
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenter
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenterPreview
import ru.pokrovskii.design.theme.api.AppTheme

@Composable
internal fun AccountScreenSuccess(
    presenter: AccountScreenPresenter,
    state: AccountScreenState.Success,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            text = stringResource(R.string.profile),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        ThemeSwitcher(
            state = state.theme,
            onSwitch = presenter::switchTheme,
        )
    }
}

@Preview
@Composable
private fun AccountScreenContentPreview() {
    AppTheme {
        Surface {
            AccountScreenSuccess(
                presenter = AccountScreenPresenterPreview(),
                state = AccountScreenState.forPreview(),
            )
        }
    }
}