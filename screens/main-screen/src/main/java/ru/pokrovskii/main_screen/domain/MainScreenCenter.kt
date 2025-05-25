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

    suspend fun changeTitle(
        blockId: String,
        newTitle: String
    ): List<LandingBlock>? {
        val result = repository.changeTitle(
            blockId = blockId,
            newTitle = newTitle,
        )

        return when (result) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }

    suspend fun deleteSong(blockId: String, id: Int): List<LandingBlock>? {
        val result = repository.deleteSong(
            blockId = blockId,
            id = id,
        )

        return when (result) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }

    suspend fun addSong(
        id: Int,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String
    ): List<LandingBlock>? {
        val result = repository.addSong(
            blockId = blockId,
            id = id,
            title = title,
            artist = artist,
            imageUrl = imageUrl,
        )

        return when (result) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }

    suspend fun addBlock(): List<LandingBlock>? {
        return when (val result = repository.addBlock()) {
            is DataOrError.Error -> null
            is DataOrError.Data -> result.data
        }
    }
}