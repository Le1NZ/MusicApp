package ru.pokrovskii.network.artist.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.pokrovskii.model.artist.FullArtist
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.artist.ArtistApi
import ru.pokrovskii.network.artist.api.ArtistRepository
import ru.pokrovskii.network.mappers.toFullArtist
import ru.pokrovskii.network.utils.toResult

internal class ArtistRepositoryImpl(
    private val api: ArtistApi,
) : ArtistRepository {

    override suspend fun getArtist(id: String): DataOrError<FullArtist> {
        return withContext(Dispatchers.IO) {
            api.getArtist(id = id)
                .toResult { artist.toFullArtist() }
        }
    }
}