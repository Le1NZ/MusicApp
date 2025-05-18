package ru.pokrovskii.screen.artist.api

import androidx.fragment.app.FragmentManager

interface ArtistScreenDependencies {

    fun createActions(fragmentManager: FragmentManager): ArtistScreenActions
}