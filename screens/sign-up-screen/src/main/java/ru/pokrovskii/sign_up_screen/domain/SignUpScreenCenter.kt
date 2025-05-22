package ru.pokrovskii.sign_up_screen.domain

import ru.pokrovskii.model.auth.UserInfo
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.auth.api.AuthRepository

internal class SignUpScreenCenter(
    private val repository: AuthRepository,
) {

    suspend fun signUp(
        login: String,
        password: String,
    ): DataOrError<UserInfo> {
        return repository.signUp(
            login = login,
            password = password,
        )
    }
}