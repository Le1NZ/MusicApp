package ru.pokrovskii.model.auth

data class UserInfo(
    val login: String,
    val token: String,
)

fun UserInfo?.isAuthorized(): Boolean {
    return this != null
}