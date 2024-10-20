package ru.pokrovskii.screen.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.design.theme.AppTheme
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.screen.search.api.SearchScreenDependencies
import ru.pokrovskii.screen.search.viewmodel.SearchScreenPresenterImpl
import ru.pokrovskii.screen.search.viewmodel.SearchScreenViewModel

internal class SearchScreenFragment : Fragment() {

    private val viewModel: SearchScreenViewModel by viewModelFactory { SearchScreenViewModel(get()) }
    private val dependencies: SearchScreenDependencies by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    SearchScreenContent(
                        state = viewModel.state.collectAsStateWithLifecycle().value,
                        presenter = remember {
                            SearchScreenPresenterImpl(
                                viewModel = viewModel,
                                actions = dependencies.createActions(parentFragmentManager),
                                viewModelStore = viewModelStore,
                            )
                        }
                    )
                }
            }
        }
    }
}