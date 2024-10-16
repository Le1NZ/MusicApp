package ru.pokrovskii.model.result

sealed class DataOrError<out T> {

    data class Data<out T>(
        val data: T,
    ) : DataOrError<T>()

    data object Error : DataOrError<Nothing>()
}