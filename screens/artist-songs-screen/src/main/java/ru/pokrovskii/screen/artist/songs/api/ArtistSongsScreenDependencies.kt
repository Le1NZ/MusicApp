package ru.pokrovskii.screen.artist.songs.api

import androidx.fragment.app.FragmentManager

interface ArtistSongsScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): ArtistSongsScreenActions
}