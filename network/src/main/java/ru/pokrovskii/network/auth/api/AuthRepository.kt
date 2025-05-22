package ru.pokrovskii.network.auth.api

import ru.pokrovskii.model.auth.UserInfo
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.auth.dto.UserDto

interface AuthRepository {

    suspend fun login(login: String, password: String): DataOrError<UserInfo>
    suspend fun signUp(login: String, password: String): DataOrError<UserInfo>
}