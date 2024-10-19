package ru.pokrovskii.screen.song.api

import android.content.Context
import androidx.fragment.app.FragmentManager

interface SongScreenDependencies {

    fun createActions(
        fragmentManager: FragmentManager,
        context: Context,
    ): SongScreenActions
}