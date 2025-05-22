package ru.pokrovskii.account_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import ru.pokrovskii.account_screen.api.AccountScreenDependencies
import ru.pokrovskii.account_screen.viewmodel.AccountScreenPresenterImpl
import ru.pokrovskii.account_screen.viewmodel.AccountScreenViewModel
import ru.pokrovskii.design.theme.api.AppTheme
import ru.pokrovskii.design.viewmodel.viewModelFactory

internal class AccountScreenFragment: Fragment() {

    private val dependencies by inject<AccountScreenDependencies>()
    private val viewModel by viewModelFactory {
        AccountScreenViewModel(
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
                    AccountScreenContent(
                        state = viewModel.state.collectAsStateWithLifecycle().value,
                        presenter = remember {
                            AccountScreenPresenterImpl(
                                actions = dependencies.createActions(parentFragmentManager),
                                viewModel = viewModel,
                            )
                        }
                    )
                }
            }
        }
    }
}