package ru.pokrovskii.implementation.song

import android.content.Context
import androidx.fragment.app.FragmentManager
import ru.pokrovskii.navigation.api.NavigationComponent
import ru.pokrovskii.screen.song.api.SongScreenActions
import ru.pokrovskii.screen.song.api.SongScreenDependencies

internal class SongScreenDependenciesImpl(
    private val navigationComponent: NavigationComponent,
) : SongScreenDependencies {

    override fun createActions(
        fragmentManager: FragmentManager,
        context: Context,
    ): SongScreenActions {
        return SongScreenActionsImpl(
            router = navigationComponent.createRouter(fragmentManager),
            context = context,
        )
    }
}