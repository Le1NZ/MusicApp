package ru.pokrovskii.sign_up_screen.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.pokrovskii.design.R
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.toolbar.AppToolbar
import ru.pokrovskii.design.toolbar.ToolbarConfig
import ru.pokrovskii.design.utils.showToast
import ru.pokrovskii.sign_up_screen.R.string
import ru.pokrovskii.sign_up_screen.ui.state.SignUpScreenEvent
import ru.pokrovskii.sign_up_screen.viewmodel.SignUpScreenPresenter
import ru.pokrovskii.sign_up_screen.viewmodel.SignUpScreenPresenterPreview

@Composable
internal fun SignUpScreenContent(
    presenter: SignUpScreenPresenter,
) {
    CollectEvents(presenter)

    Column(
        modifier = Modifier
            .systemBarsPadding(),
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
            text = presenter.loginText.collectAsStateWithLifecycle(),
            onChanged = presenter::onLoginTextChanged,
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_password),
            text = presenter.passwordText.collectAsStateWithLifecycle(),
            onChanged = presenter::onPasswordTextChanged,
        )

        SignUpTextField(
            placeholderText = stringResource(string.input_password_again),
            text = presenter.passwordAgainText.collectAsStateWithLifecycle(),
            onChanged = presenter::onPasswordAgainTextChanged,
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Text(
            modifier = Modifier
                .clickable(onClick = presenter::toLogin)
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp),
            text = stringResource(string.already_have_account),
            color = MaterialTheme.colorScheme.onBackground,
        )

        val isSignUpInProgress by presenter.isSignUpInProgress.collectAsStateWithLifecycle()
        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp),
            onClick = presenter::startSignUp,
            enabled = !isSignUpInProgress,
        ) {
            if (isSignUpInProgress) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onSecondary,
                )
            } else {
                Text(
                    text = stringResource(string.sign_up),
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
private fun SignUpTextField(
    placeholderText: String,
    text: State<String>,
    onChanged: (String) -> Unit,
) {
    val textValue by text
    TextField(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        value = textValue,
        onValueChange = onChanged,
        placeholder = { Text(text = placeholderText) },
        trailingIcon = {
            if (textValue.isNotEmpty()) {
                IconButton(
                    onClick = { onChanged("") },
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

@Composable
private fun CollectEvents(
    presenter: SignUpScreenPresenter,
) {
    val context = LocalContext.current

    val loginFailed = stringResource(id = string.sign_up_error)
    val passwordsNotMatches = stringResource(id = string.passwords_not_matches)
    LaunchedEffect(Unit) {
        presenter.events.collect { event ->
            when (event) {
                is SignUpScreenEvent.PasswordsNotMatches -> context.showToast(passwordsNotMatches)
                is SignUpScreenEvent.SignUpFailed -> context.showToast(loginFailed)
                is SignUpScreenEvent.SignUpSuccess -> presenter.onLoginSuccess()
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenContentPreview() {
    AppTheme {
        Surface {
            SignUpScreenContent(
                presenter = SignUpScreenPresenterPreview()
            )
        }
    }
}