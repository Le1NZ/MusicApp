package ru.pokrovskii.screen.artist.songs.ui

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
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenApi
import ru.pokrovskii.screen.artist.songs.api.ArtistSongsScreenDependencies
import ru.pokrovskii.screen.artist.songs.viewmodel.ArtistSongsScreenPresenterImpl
import ru.pokrovskii.screen.artist.songs.viewmodel.ArtistSongsScreenViewModel

internal class ArtistSongsScreenFragment : Fragment() {

    companion object {

        private const val KEY_ARGS = "artist_screen_args"

        fun newInstance(args: ArtistSongsScreenApi.Args): Fragment {
            return ArtistSongsScreenFragment().apply {
                arguments = bundleOf(KEY_ARGS to args)
            }
        }
    }

    private val args: ArtistSongsScreenApi.Args
        get() = requireNotNull(
            requireArguments().getParcelable(KEY_ARGS)
        )
    private val dependencies: ArtistSongsScreenDependencies by inject()
    private val viewModel by viewModelFactory {
        ArtistSongsScreenViewModel(
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
                    ArtistSongsScreenContent(
                        presenter = remember {
                            ArtistSongsScreenPresenterImpl(
                                actions = dependencies.createActions(
                                    fragmentManager = parentFragmentManager,
                                ),
                                viewModel = viewModel,
                                viewModelStore = viewModelStore,
                            )
                        }
                    )
                }
            }
        }
    }
}