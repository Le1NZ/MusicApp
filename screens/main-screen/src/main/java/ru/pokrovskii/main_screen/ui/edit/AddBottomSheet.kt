package ru.pokrovskii.main_screen.ui.edit

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.pokrovskii.design.search.SearchField
import ru.pokrovskii.main_screen.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddBottomSheet(
    onAdd: (
        id: String,
        title: String,
        artist: String,
        imageUrl: String
    ) -> Unit,
    onDismiss: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    var title by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }

    ModalBottomSheet(
        onDismissRequest = {
            scope.launch { sheetState.hide() }.invokeOnCompletion {
                onDismiss()
            }
        },
        sheetState = sheetState,
    ) {
        SearchField(
            query = title,
            onQueryChanged = { title = it },
            placeholderText = stringResource(id = R.string.add_title),
        )

        Spacer(modifier = Modifier.height(8.dp))

        SearchField(
            query = id,
            onQueryChanged = { id = it },
            keyboardType = KeyboardType.Number,
            placeholderText = stringResource(id = R.string.add_id),
            isNeedToRequestFocus = false,
        )

        Spacer(modifier = Modifier.height(8.dp))

        SearchField(
            query = artist,
            onQueryChanged = { artist = it },
            placeholderText = stringResource(id = R.string.add_artist),
            isNeedToRequestFocus = false,
        )

        Spacer(modifier = Modifier.height(8.dp))

        SearchField(
            query = imageUrl,
            onQueryChanged = { imageUrl = it },
            placeholderText = stringResource(id = R.string.add_image_url),
            isNeedToRequestFocus = false,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            onClick = {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        onDismiss()
                    }

                    onAdd(id, title, artist, imageUrl)
                }
            },
        ) {
            Text(
                text = stringResource(R.string.add),
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.imePadding())
    }
}