package ru.pokrovskii.account_screen.ui.success

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.account_screen.R
import ru.pokrovskii.account_screen.ui.state.AccountAppThemeState
import ru.pokrovskii.design.theme.api.AppTheme

@Composable
internal fun ThemeSwitcher(
    state: AccountAppThemeState,
    onSwitch: (newState: AccountAppThemeState) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .selectableGroup(),
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 16.dp),
            text = stringResource(R.string.application_theme),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        AccountAppThemeState.themeList.forEach { theme ->
            ThemeSwitch(
                currentTheme = state,
                thisTheme = theme,
                onClick = onSwitch,
            )
        }
    }
}

@Composable
private fun ThemeSwitch(
    currentTheme: AccountAppThemeState,
    thisTheme: AccountAppThemeState,
    onClick: (newState: AccountAppThemeState) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isSelected = remember(currentTheme, thisTheme) { currentTheme == thisTheme }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .selectable(
                selected = isSelected,
                onClick = { onClick(thisTheme) },
                role = Role.RadioButton,
            )
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null,
        )
        Text(
            text = thisTheme.toName(),
            fontSize = 20.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Composable
private fun AccountAppThemeState.toName(): String {
    val resId = when (this) {
        is AccountAppThemeState.System -> R.string.system_theme
        is AccountAppThemeState.Dark -> R.string.dark_theme
        is AccountAppThemeState.Light -> R.string.light_theme
    }

    return stringResource(id = resId)
}

@Preview
@Composable
private fun ThemeSwitcherPreview() {
    AppTheme {
        Surface {
            ThemeSwitcher(
                state = AccountAppThemeState.forPreview(),
                onSwitch = { },
            )
        }
    }
}