package ru.pokrovskii.screen.artist.songs.api

import android.os.Parcelable
import androidx.fragment.app.Fragment
import kotlinx.parcelize.Parcelize
import ru.pokrovskii.screen.artist.songs.ui.ArtistSongsScreenFragment

object ArtistSongsScreenApi {

    fun createFragment(args: Args): Fragment {
        return ArtistSongsScreenFragment.newInstance(args)
    }

    @Parcelize
    data class Args(
        val id: String,
        val name: String,
    ) : Parcelable
}