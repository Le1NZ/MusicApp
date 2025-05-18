package ru.pokrovskii.network.artist.api

import ru.pokrovskii.model.artist.FullArtist
import ru.pokrovskii.model.result.DataOrError

interface ArtistRepository {

    suspend fun getArtist(id: String): DataOrError<FullArtist>
}