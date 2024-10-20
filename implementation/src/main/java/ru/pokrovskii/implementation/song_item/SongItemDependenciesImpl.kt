package ru.pokrovskii.implementation.song_item

import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.song.item.api.deps.SongItemActions
import ru.pokrovskii.song.item.api.deps.SongItemDependencies

internal class SongItemDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : SongItemDependencies {

    override fun createActions(fragmentManager: FragmentManager): SongItemActions {
        return SongItemActionsImpl(navigationComponent.createRouter(fragmentManager))
    }
}