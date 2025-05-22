package ru.pokrovskii.log_in_screen.ui

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
import ru.pokrovskii.log_in_screen.api.LoginScreenDependencies
import ru.pokrovskii.log_in_screen.viewmodel.LoginScreenPresenter
import ru.pokrovskii.log_in_screen.viewmodel.LoginScreenPresenterImpl
import ru.pokrovskii.log_in_screen.viewmodel.LoginScreenViewModel

internal class LoginScreenFragment : Fragment() {

    companion object {

        fun newInstance(): Fragment {
            return LoginScreenFragment()
        }
    }

    private val dependencies: LoginScreenDependencies by inject()
    private val viewModel by viewModelFactory {
        LoginScreenViewModel(
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
                    LoginScreenContent(
                        presenter = remember {
                            LoginScreenPresenterImpl(
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