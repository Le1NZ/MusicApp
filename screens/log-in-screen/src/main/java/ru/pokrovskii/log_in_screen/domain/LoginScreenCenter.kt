package ru.pokrovskii.log_in_screen.domain

import ru.pokrovskii.model.auth.UserInfo
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.auth.api.AuthRepository

internal class LoginScreenCenter(
    private val repository: AuthRepository,
) {

    suspend fun login(
        login: String,
        password: String,
    ): DataOrError<UserInfo> {
        return repository.login(
            login = login,
            password = password,
        )
    }
}