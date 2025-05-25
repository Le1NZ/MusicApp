package ru.pokrovskii.network.landing.api

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.result.DataOrError

interface LandingRepository {

    suspend fun loadLanding(): DataOrError<List<LandingBlock>>
    suspend fun changeTitle(blockId: String, newTitle: String): DataOrError<List<LandingBlock>>
    suspend fun deleteSong(blockId: String, id: Int): DataOrError<List<LandingBlock>>

    suspend fun addSong(
        id: Int,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String,
    ): DataOrError<List<LandingBlock>>

    suspend fun addBlock(): DataOrError<List<LandingBlock>>
}