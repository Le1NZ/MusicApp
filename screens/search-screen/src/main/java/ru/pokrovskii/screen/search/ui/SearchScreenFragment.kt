package ru.pokrovskii.screen.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.activityViewModels
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.network.search.api.SearchRepository
import ru.pokrovskii.screen.search.api.SearchScreenDependencies
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenterImpl
import ru.pokrovskii.screen.search.viewmodel.SearchScreenViewModel

internal class SearchScreenFragment : Fragment() {

    private val viewModel: SearchScreenViewModel by viewModel()
    private val dependencies: SearchScreenDependencies by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    SearchScreenContent(
                        state = viewModel.state.collectAsState().value,
                        presenter = remember {
                            SearchScreenPresenterImpl(
                                viewModel = viewModel,
                                actions = dependencies.createActions(parentFragmentManager),
                            )
                        }
                    )
                }
            }
        }
    }
}