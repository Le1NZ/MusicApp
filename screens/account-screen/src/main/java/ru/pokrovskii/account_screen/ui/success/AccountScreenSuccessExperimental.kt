package ru.pokrovskii.account_screen.ui.success

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import ru.pokrovskii.account_screen.R
import ru.pokrovskii.design.theme.api.AppTheme

@Composable
internal fun AccountScreenSuccessExperimental() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
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

        AccountName(
            name = "Name",
        )

        AccountCountSongs(
            count = 25,
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        AccountButton(
            text = stringResource(R.string.change_nickname),
        )

        AccountButton(
            text = stringResource(R.string.log_out),
        )
    }
}

@Composable
private fun AccountName(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp),
        text = name,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
    )
}

@Composable
private fun AccountCountSongs(
    count: Int,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier
            .padding(horizontal = 16.dp),
        text = stringResource(R.string.count_liked_songs, count),
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onBackground,
    )
}

@Composable
private fun AccountButton(
    text: String,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .padding(horizontal = 16.dp),
        onClick = { },
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSecondary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun AccountScreenContentPreview() {
    AppTheme {
        Surface {
            AccountScreenSuccessExperimental()
        }
    }
}