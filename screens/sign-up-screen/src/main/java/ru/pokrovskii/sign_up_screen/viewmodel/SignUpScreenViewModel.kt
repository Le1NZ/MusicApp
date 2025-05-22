package ru.pokrovskii.sign_up_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.sign_up_screen.domain.SignUpScreenCenter
import ru.pokrovskii.sign_up_screen.ui.state.SignUpScreenEvent

internal class SignUpScreenViewModel(
    private val center: SignUpScreenCenter,
    userCenterLazy: Lazy<UserCenter>,
) : ViewModel() {

    private val userCenter by userCenterLazy

    private val _events = MutableSharedFlow<SignUpScreenEvent>()
    val events: SharedFlow<SignUpScreenEvent> = _events

    private val _isSignUpInProgress = MutableStateFlow(false)
    val isSignUpInProgress: StateFlow<Boolean> = _isSignUpInProgress

    private val _loginText = MutableStateFlow("")
    val loginText: StateFlow<String> = _loginText

    private val _passwordText = MutableStateFlow("")
    val passwordText: StateFlow<String> = _passwordText

    private val _passwordAgainText = MutableStateFlow("")
    val passwordAgainText: StateFlow<String> = _passwordAgainText

    private var loginJob: Job? = null

    fun startSignUp() {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            signUp()
        }
    }

    fun onLoginTextChanged(text: String) {
        _loginText.value = text
    }

    fun onPasswordTextChanged(text: String) {
        _passwordText.value = text
    }

    fun onPasswordAgainTextChanged(text: String) {
        _passwordAgainText.value = text
    }

    private suspend fun signUp() {
        _isSignUpInProgress.value = true

        if (passwordAgainText.value != passwordText.value) {
            _events.emit(SignUpScreenEvent.PasswordsNotMatches)
            _isSignUpInProgress.value = false
            return
        }

        val result = center.signUp(
            login = loginText.value,
            password = passwordText.value,
        )

        val event = when (result) {
            is DataOrError.Data -> {
                userCenter.login(userInfo = result.data)
                SignUpScreenEvent.SignUpSuccess
            }
            is DataOrError.Error -> SignUpScreenEvent.SignUpFailed
        }

        _events.emit(event)
        _isSignUpInProgress.value = false
    }
}