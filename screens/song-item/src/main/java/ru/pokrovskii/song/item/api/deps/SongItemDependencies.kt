package ru.pokrovskii.song.item.api.deps

import androidx.fragment.app.FragmentManager

interface SongItemDependencies {

    fun createActions(fragmentManager: FragmentManager): SongItemActions
}