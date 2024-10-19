package ru.pokrovskii.model.utils

fun <T> List<T>.takeIfNotNull(): List<T>? {
    return this.takeIf { it.isNotEmpty() }
}