package ru.pokrovskii.screen.song.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.screen.song.api.SongScreenApi
import ru.pokrovskii.screen.song.api.SongScreenDependencies
import ru.pokrovskii.screen.viewmodel.SongScreenPresenterImpl
import ru.pokrovskii.screen.viewmodel.SongScreenViewModel

internal class SongScreenFragment : Fragment() {

    private val args: SongScreenApi.Args get() = requireNotNull(
        requireArguments().getParcelable(KET_ARGS)
    )
    private val dependencies: SongScreenDependencies by inject()
    private val viewModel: SongScreenViewModel by viewModelFactory {
        SongScreenViewModel(
            args = args,
            songScreenCenter = get(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    SongScreenContent(
                        state = viewModel.state.collectAsStateWithLifecycle().value,
                        presenter = remember {
                            SongScreenPresenterImpl(
                                actions = dependencies.createActions(
                                    fragmentManager = parentFragmentManager,
                                    context = requireContext(),
                                ),
                                viewModel = viewModel,
                            )
                        }
                    )
                }
            }
        }
    }

    companion object {

        private const val KET_ARGS = "songScreen:args"

        fun newInstance(args: SongScreenApi.Args): SongScreenFragment {
            return SongScreenFragment().apply {
                arguments = bundleOf(KET_ARGS to args)
            }
        }
    }
}