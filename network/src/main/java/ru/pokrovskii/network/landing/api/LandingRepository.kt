package ru.pokrovskii.network.landing.api

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.result.DataOrError

interface LandingRepository {

    suspend fun loadLanding(): DataOrError<List<LandingBlock>>
}