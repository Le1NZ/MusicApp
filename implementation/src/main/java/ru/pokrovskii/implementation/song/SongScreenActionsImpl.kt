package ru.pokrovskii.implementation.song

import android.content.Context
import android.content.Intent
import android.net.Uri
import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.screen.song.api.SongScreenActions

internal class SongScreenActionsImpl(
    private val router: Router,
    private val context: Context,
) : SongScreenActions {

    override fun onFavoriteClick() {
        router.openScreen(Screen.Favorites)
    }

    override fun onSearchClick() {
        router.openScreen(Screen.Search)
    }

    override fun onToTextButtonClick(url: String) {
        val urlIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        context.startActivity(urlIntent)
    }
}