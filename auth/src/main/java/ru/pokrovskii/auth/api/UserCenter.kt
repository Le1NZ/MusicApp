package ru.pokrovskii.auth.api

import kotlinx.coroutines.flow.Flow
import ru.pokrovskii.model.auth.UserInfo

interface UserCenter {

    val users: Flow<UserInfo?>

    fun currentUserBlocking(): UserInfo?

    suspend fun login(userInfo: UserInfo)
    suspend fun logout()
}