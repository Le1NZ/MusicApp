package ru.pokrovskii.screen.artist.domain

import ru.pokrovskii.model.artist.FullArtist
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.artist.api.ArtistRepository

internal class ArtistScreenCenter(
    private val repository: ArtistRepository,
) {

    suspend fun getArtist(id: String): FullArtist? {
        return when (val result = repository.getArtist(id = id)) {
            is DataOrError.Data -> result.data
            is DataOrError.Error -> null
        }
    }
}