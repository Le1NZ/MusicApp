package ru.pokrovskii.sign_up_screen.ui

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
import ru.pokrovskii.sign_up_screen.api.SignUpScreenDependencies
import ru.pokrovskii.sign_up_screen.viewmodel.SignUpScreenPresenterImpl
import ru.pokrovskii.sign_up_screen.viewmodel.SignUpScreenViewModel

internal class SignUpScreenFragment : Fragment() {

    companion object {

        fun newInstance(): Fragment {
            return SignUpScreenFragment()
        }
    }

    private val dependencies: SignUpScreenDependencies by inject()
    private val viewModel by viewModelFactory {
        SignUpScreenViewModel(
            center = get(),
            userCenterLazy = inject(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    SignUpScreenContent(
                        presenter = remember {
                            SignUpScreenPresenterImpl(
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