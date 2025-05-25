package ru.pokrovskii.main_screen.domain

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.landing.api.LandingRepository

internal class MainScreenCenter(
    repositoryLazy: Lazy<LandingRepository>,
) {

    private val repository by repositoryLazy

    suspend fun loadLanding(): List<LandingBlock>? {
        return when (val result = repository.loadLanding()) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }
}