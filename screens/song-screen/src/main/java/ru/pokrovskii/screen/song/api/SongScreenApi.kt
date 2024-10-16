package ru.pokrovskii.screen.song.api

import android.os.Parcelable
import androidx.fragment.app.Fragment
import kotlinx.parcelize.Parcelize
import ru.pokrovskii.screen.song.ui.SongScreenFragment

object SongScreenApi {

    fun createFragment(args: Args): Fragment {
        return SongScreenFragment.newInstance(args)
    }

    @Parcelize
    data class Args(
        val id: Int,
    ) : Parcelable
}