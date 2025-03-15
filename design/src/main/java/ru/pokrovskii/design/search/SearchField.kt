package ru.pokrovskii.design.search

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.pokrovskii.design.R
import ru.pokrovskii.design.theme.AppTheme


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchField(
    query: String,
    onQueryChanged: (String) -> Unit,
    placeholderText: String,
    modifier: Modifier = Modifier,
) {
    val imeIsVisible = WindowInsets.isImeVisible
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val textFieldValue = remember(query) {
        TextFieldValue(
            text = query,
            selection = TextRange(query.length),
        )
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        value = textFieldValue,
        onValueChange = { newQuery -> onQueryChanged(newQuery.text) },
        placeholder = { Text(text = placeholderText) },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(
                    onClick = {
                        keyboardController?.hide()
                        onQueryChanged("")
                    },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close_24),
                        contentDescription = null,
                    )
                }
            }
        },
        keyboardActions = KeyboardActions(
            onDone = {
                if (imeIsVisible) {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                } else {
                    keyboardController?.show()
                }
            },
        ),
        singleLine = true,
        maxLines = 1,
    )
}

@Preview
@Composable
private fun SearchFieldPreviewEmpty() {
    AppTheme {
        Surface {
            SearchField(
                query = "",
                onQueryChanged = { },
                placeholderText = "Пока пусто",
            )
        }
    }
}

@Preview
@Composable
private fun SearchFieldPreview() {
    AppTheme {
        Surface {
            SearchField(
                query = "Запрос",
                onQueryChanged = { },
                placeholderText = "Пока пусто",
            )
        }
    }
}