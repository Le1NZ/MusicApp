package ru.pokrovskii.network.auth.impl

import ru.pokrovskii.model.auth.UserInfo
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.auth.AuthApi
import ru.pokrovskii.network.auth.api.AuthRepository
import ru.pokrovskii.network.auth.dto.LoginDto
import ru.pokrovskii.network.auth.dto.SignUpDto
import ru.pokrovskii.network.mappers.toUser
import ru.pokrovskii.network.utils.toSimpleResult

internal class AuthRepositoryImpl(
    private val api: AuthApi,
) : AuthRepository {

    override suspend fun login(login: String, password: String): DataOrError<UserInfo> {
        return api.login(
            loginInfo = LoginDto(
                login = login,
                password = password,
            )
        ).toSimpleResult { toUser() }
    }

    override suspend fun signUp(login: String, password: String): DataOrError<UserInfo> {
        return api.signUp(
            signUpInfo = SignUpDto(
                login = login,
                password = password,
            )
        ).toSimpleResult { toUser() }
    }
}