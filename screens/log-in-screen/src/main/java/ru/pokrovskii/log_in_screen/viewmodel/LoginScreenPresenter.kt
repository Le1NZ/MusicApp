package ru.pokrovskii.log_in_screen.viewmodel

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.log_in_screen.api.LoginScreenActions
import ru.pokrovskii.log_in_screen.ui.state.LoginScreenEvent

@Stable
internal interface LoginScreenPresenter {

    val loginText: StateFlow<String>
    val passwordText: StateFlow<String>

    fun onLoginTextChanged(text: String)
    fun onPasswordTextChanged(text: String)

    val events: SharedFlow<LoginScreenEvent>
    val isLoginInProgress: StateFlow<Boolean>

    fun login()
    fun toSignUp()
    fun onLoginSuccess()
}

internal class LoginScreenPresenterImpl(
    private val viewModel: LoginScreenViewModel,
    private val actions: LoginScreenActions,
) : LoginScreenPresenter {

    override val loginText = viewModel.loginText
    override val passwordText = viewModel.passwordText

    override fun onLoginTextChanged(text: String) {
        viewModel.onLoginTextChanged(text)
    }

    override fun onPasswordTextChanged(text: String) {
        viewModel.onPasswordTextChanged(text)
    }

    override val events = viewModel.events
    override val isLoginInProgress = viewModel.isLoginInProgress

    override fun login() {
        viewModel.startLogin()
    }

    override fun toSignUp() {
        actions.toSignUp()
    }

    override fun onLoginSuccess() {
        actions.onLoginSuccess()
    }
}

internal class LoginScreenPresenterPreview : LoginScreenPresenter {

    override val loginText = MutableStateFlow("")
    override val passwordText = MutableStateFlow("")

    override fun onLoginTextChanged(text: String) = Unit
    override fun onPasswordTextChanged(text: String) = Unit

    override val events = MutableSharedFlow<LoginScreenEvent>()
    override val isLoginInProgress = MutableStateFlow(false)

    override fun login() = Unit
    override fun toSignUp() = Unit

    override fun onLoginSuccess() = Unit
}