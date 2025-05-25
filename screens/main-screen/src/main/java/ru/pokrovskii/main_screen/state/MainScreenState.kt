package ru.pokrovskii.main_screen.state

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface MainScreenState {

    data object Loading : MainScreenState
    data object Error : MainScreenState

    data class Success(
        val blocks: List<LandingBlockState>,
    ) : MainScreenState

    companion object {

        fun forPreview(): Success {
            return Success(
                blocks = List(3) { LandingBlockState.forPreview(it) },
            )
        }
    }
}
