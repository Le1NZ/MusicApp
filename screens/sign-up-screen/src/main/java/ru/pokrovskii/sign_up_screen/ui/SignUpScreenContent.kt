package ru.pokrovskii.sign_up_screen.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.pokrovskii.design.R
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.sign_up_screen.R.string

@Composable
internal fun SignUpScreenContent(

) {
    Column(
        modifier = Modifier
            .statusBarsPadding(),
    ) {
        AppToolbar(
            config = ToolbarConfig(
                icons = emptyList(),
            )
        )

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            text = stringResource(string.sign_up_account),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_e_mail),
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_nickname),
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_password),
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_password_again),
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        ClickableText(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            text = AnnotatedString(stringResource(string.already_have_account)),
            onClick = { },
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp),
            onClick = { },
        ) {
            Text(
                text = stringResource(string.sign_up),
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun SignUpTextField(
    placeholderText: String,
) {
    TextField(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        value = "Test",
        onValueChange = { },
        placeholder = { Text(text = placeholderText) },
        trailingIcon = {
            if (true) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close_24),
                        contentDescription = null,
                    )
                }
            }
        },
        singleLine = true,
        maxLines = 1,
    )
}

@Preview
@Composable
private fun LoginScreenContentPreview() {
    AppTheme {
        Surface {
            SignUpScreenContent(
            )
        }
    }
}