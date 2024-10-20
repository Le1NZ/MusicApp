package ru.pokrovskii.implementation.song_item

import ru.pokrovskii.model.screen.Screen
import ru.pokrovskii.navigation.api.Router
import ru.pokrovskii.song.item.api.deps.SongItemActions

internal class SongItemActionsImpl(
    private val router: Router,
) : SongItemActions {

    override fun onSongItemClick(id: Int) {
        router.openScreen(Screen.Song(id))
    }
}