package ru.pokrovskii.main_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.viewmodel.viewModelFactory
import ru.pokrovskii.main_screen.api.MainScreenDependencies
import ru.pokrovskii.main_screen.viewmodel.MainScreenPresenterImpl
import ru.pokrovskii.main_screen.viewmodel.MainScreenViewModel

internal class MainScreenFragment : Fragment() {

    companion object {

        fun newInstance(): Fragment {
            return MainScreenFragment()
        }
    }

    private val dependencies: MainScreenDependencies by inject()
    private val viewModel by viewModelFactory {
        MainScreenViewModel(
            center = get(),
            userCenterLazy = inject(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    MainScreenContent(
                        presenter = remember {
                            MainScreenPresenterImpl(
                                viewModel = viewModel,
                                actions = dependencies.createActions(
                                    fragmentManager = parentFragmentManager,
                                ),
                            )
                        }
                    )
                }
            }
        }
    }
}