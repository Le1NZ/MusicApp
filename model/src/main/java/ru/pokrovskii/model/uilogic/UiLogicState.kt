package ru.pokrovskii.model.uilogic

sealed interface UiLogicState<out T> {

    data object Loading : UiLogicState<Nothing>
    data object Error : UiLogicState<Nothing>

    data class Success<T>(
        val data: List<T>,
    ) : UiLogicState<T>
}