package ru.pokrovskii.auth.center

import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.auth.storage.UserStorage
import ru.pokrovskii.auth.storage.toUserInfo
import ru.pokrovskii.auth.storage.toUserStorageModel
import ru.pokrovskii.model.auth.UserInfo

internal class UserCenterImpl(
    private val storage: UserStorage,
) : UserCenter {

    override val users = storage.user.map { it?.toUserInfo() }

    override fun currentUserBlocking(): UserInfo? {
        return runBlocking { users.firstOrNull() }
    }

    override suspend fun login(userInfo: UserInfo) {
        storage.setUser(
            userStorageModel = userInfo.toUserStorageModel(),
        )
    }

    override suspend fun logout() {
        storage.clearUser()
    }
}