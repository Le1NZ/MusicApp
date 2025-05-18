package ru.pokrovskii.screen.artist.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.screen.artist.api.ArtistScreenApi
import ru.pokrovskii.screen.artist.api.ArtistScreenDependencies
import ru.pokrovskii.screen.artist.viewmodel.ArtistScreenPresenterImpl
import ru.pokrovskii.screen.artist.viewmodel.ArtistScreenViewModel

internal class ArtistScreenFragment : Fragment() {

    companion object {

        private const val KEY_ARGS = "artist_screen_args"

        fun newInstance(args: ArtistScreenApi.Args): Fragment {
            return ArtistScreenFragment().apply {
                arguments = bundleOf(KEY_ARGS to args)
            }
        }
    }

    private val args: ArtistScreenApi.Args
        get() = requireNotNull(
            requireArguments().getParcelable(KEY_ARGS)
        )
    private val dependencies: ArtistScreenDependencies by inject()
    private val viewModel by viewModelFactory {
        ArtistScreenViewModel(
            args = args,
            center = get(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ArtistScreenContent(
                        presenter = remember {
                            ArtistScreenPresenterImpl(
                                actions = dependencies.createActions(
                                    fragmentManager = parentFragmentManager,
                                ),
                                viewModel = viewModel,
                            )
                        }
                    )
                }
            }
        }
    }
}