package ru.pokrovskii.network.landing.impl

import ru.pokrovskii.model.landing.LandingBlock
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.landing.LandingApi
import ru.pokrovskii.network.landing.api.LandingRepository
import ru.pokrovskii.network.landing.dto.AddSongDto
import ru.pokrovskii.network.landing.dto.ChangeTitleDto
import ru.pokrovskii.network.landing.dto.DeleteSongDto
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

    override suspend fun changeTitle(
        blockId: String,
        newTitle: String
    ): DataOrError<List<LandingBlock>> {
        return api.changeBlockTitle(
            title = ChangeTitleDto(
                newTitle = newTitle,
                blockId = blockId,
            ),
        ).toSimpleResult { blocks.map { it.toLandingBlock() } }
    }

    override suspend fun deleteSong(blockId: String, id: Int): DataOrError<List<LandingBlock>> {
        return api.deleteSong(
            song = DeleteSongDto(
                id = id,
                blockId = blockId,
            ),
        ).toSimpleResult { blocks.map { it.toLandingBlock() } }
    }

    override suspend fun addSong(
        id: Int,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String
    ): DataOrError<List<LandingBlock>> {
        return api.addSong(
            song = AddSongDto(
                id = id,
                imageUrl = imageUrl,
                artist = artist,
                title = title,
                blockId = blockId,
            ),
        ).toSimpleResult { blocks.map { it.toLandingBlock() } }
    }

    override suspend fun addBlock(): DataOrError<List<LandingBlock>> {
        return api.addBlock().toSimpleResult { blocks.map { it.toLandingBlock() } }
    }
}
