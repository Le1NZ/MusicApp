package ru.pokrovskii.log_in_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.log_in_screen.domain.LoginScreenCenter
import ru.pokrovskii.log_in_screen.ui.state.LoginScreenEvent
import ru.pokrovskii.model.result.DataOrError

internal class LoginScreenViewModel(
    private val center: LoginScreenCenter,
    userCenterLazy: Lazy<UserCenter>,
) : ViewModel() {

    private val userCenter by userCenterLazy

    private val _events = MutableSharedFlow<LoginScreenEvent>()
    val events: SharedFlow<LoginScreenEvent> = _events

    private val _isLoginInProgress = MutableStateFlow(false)
    val isLoginInProgress: StateFlow<Boolean> = _isLoginInProgress

    private val _loginText = MutableStateFlow("")
    val loginText: StateFlow<String> = _loginText

    private val _passwordText = MutableStateFlow("")
    val passwordText: StateFlow<String> = _passwordText

    private var loginJob: Job? = null

    fun startLogin() {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            login()
        }
    }

    fun onLoginTextChanged(text: String) {
        _loginText.value = text
    }

    fun onPasswordTextChanged(text: String) {
        _passwordText.value = text
    }

    private suspend fun login() {
        val result = center.login(
            login = loginText.value,
            password = passwordText.value,
        )

        val event = when (result) {
            is DataOrError.Data -> {
                userCenter.login(userInfo = result.data)
                LoginScreenEvent.LoginSuccess
            }
            is DataOrError.Error -> LoginScreenEvent.LoginFailed
        }

        _events.emit(event)
    }
}