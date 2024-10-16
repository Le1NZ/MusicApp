package ru.pokrovskii.screen.song.api

import androidx.fragment.app.FragmentManager

interface SongScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): SongScreenActions
}