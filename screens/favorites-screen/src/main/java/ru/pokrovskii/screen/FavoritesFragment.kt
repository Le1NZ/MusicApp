package ru.pokrovskii.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import ru.pokrovskii.screen.favorites.R
import ru.pokrovskii.screen.favorites.ui.FavoritesScreenContent

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                FavoritesScreenContent()
            }
        }
    }
}