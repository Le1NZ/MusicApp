package ru.pokrovskii.network.landing.impl

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.landing.LandingApi
import ru.pokrovskii.network.landing.api.LandingRepository
import ru.pokrovskii.network.landing.dto.toLandingBlock
import ru.pokrovskii.network.utils.toSimpleResult

internal class LandingRepositoryImpl(
    apiLazy: Lazy<LandingApi>,
) : LandingRepository {

    private val api by apiLazy

    override suspend fun loadLanding(): DataOrError<List<LandingBlock>> {
        return api
            .loadLanding()
            .toSimpleResult { blocks.map { it.toLandingBlock() } }
    }
}
