package ru.pokrovskii.screen.favorites.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.get
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.screen.favorites.api.FavoritesScreenDependencies
import ru.pokrovskii.screen.favorites.viewmodel.FavoritesScreenPresenterImpl
import ru.pokrovskii.screen.favorites.viewmodel.FavoritesScreenViewModel

class FavoritesScreenFragment : Fragment() {

    private val dependencies by inject<FavoritesScreenDependencies>()
    private val viewModel by viewModelFactory {
        FavoritesScreenViewModel(
            favoritesScreenCenter = get(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                FavoritesScreenContent(
                    state = viewModel.state.collectAsStateWithLifecycle().value,
                    presenter = remember {
                        FavoritesScreenPresenterImpl(
                            actions = dependencies.createActions(parentFragmentManager),
                        )
                    }
                )
            }
        }
    }
}