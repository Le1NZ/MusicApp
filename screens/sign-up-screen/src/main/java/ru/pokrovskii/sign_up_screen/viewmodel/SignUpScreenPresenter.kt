package ru.pokrovskii.sign_up_screen.viewmodel

import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import ru.pokrovskii.sign_up_screen.api.SignUpScreenActions
import ru.pokrovskii.sign_up_screen.ui.state.SignUpScreenEvent

@Stable
internal interface SignUpScreenPresenter {

    val loginText: StateFlow<String>
    val passwordText: StateFlow<String>
    val passwordAgainText: StateFlow<String>

    fun onLoginTextChanged(text: String)
    fun onPasswordTextChanged(text: String)
    fun onPasswordAgainTextChanged(text: String)

    val events: SharedFlow<SignUpScreenEvent>
    val isSignUpInProgress: StateFlow<Boolean>

    fun startSignUp()
    fun toLogin()
    fun onLoginSuccess()
}

internal class SignUpScreenPresenterImpl(
    private val viewModel: SignUpScreenViewModel,
    private val actions: SignUpScreenActions,
) : SignUpScreenPresenter {

    override val loginText = viewModel.loginText
    override val passwordText = viewModel.passwordText
    override val passwordAgainText = viewModel.passwordAgainText

    override fun onLoginTextChanged(text: String) {
        viewModel.onLoginTextChanged(text)
    }

    override fun onPasswordTextChanged(text: String) {
        viewModel.onPasswordTextChanged(text)
    }

    override fun onPasswordAgainTextChanged(text: String) {
        viewModel.onPasswordAgainTextChanged(text)
    }

    override val events = viewModel.events
    override val isSignUpInProgress = viewModel.isSignUpInProgress

    override fun startSignUp() {
        viewModel.startSignUp()
    }

    override fun toLogin() {
        actions.toLogin()
    }

    override fun onLoginSuccess() {
        actions.onSignUpSuccess()
    }
}

internal class SignUpScreenPresenterPreview : SignUpScreenPresenter {

    override val loginText = MutableStateFlow("")
    override val passwordText = MutableStateFlow("")
    override val passwordAgainText = MutableStateFlow("")

    override fun onLoginTextChanged(text: String) = Unit
    override fun onPasswordTextChanged(text: String) = Unit
    override fun onPasswordAgainTextChanged(text: String) = Unit

    override val events = MutableSharedFlow<SignUpScreenEvent>()
    override val isSignUpInProgress = MutableStateFlow(false)

    override fun startSignUp() = Unit
    override fun toLogin() = Unit

    override fun onLoginSuccess() = Unit
}