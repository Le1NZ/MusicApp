package ru.pokrovskii.network.mappers

import ru.pokrovskii.model.auth.UserInfo
import ru.pokrovskii.network.auth.dto.UserDto

internal fun UserDto.toUser(): UserInfo {
    return UserInfo(
        login = login,
        token = token,
        isAdmin = isAdmin,
    )
}