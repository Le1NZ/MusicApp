package ru.pokrovskii.auth.storage

import ru.pokrovskii.model.auth.UserInfo

internal fun UserInfo.toUserStorageModel(): UserStorageModel {
    return UserStorageModel(
        login = login,
        token = token,
        isAdmin = isAdmin,
    )
}

internal fun UserStorageModel.toUserInfo(): UserInfo {
    return UserInfo(
        login = login,
        token = token,
        isAdmin = isAdmin,
    )
}
