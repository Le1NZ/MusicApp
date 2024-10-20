package ru.pokrovskii.screen.song.ui.mapper

import ru.pokrovskii.design.artist.ArtistUiModelConverter
import ru.pokrovskii.model.song.Song
import ru.pokrovskii.screen.song.ui.state.SongUiModel

internal object SongUiModelConverter {

    fun convert(song: Song, isLiked: Boolean): SongUiModel {
        return SongUiModel(
            title = song.title,
            recordingLocation = song.recordingLocation,
            releaseDate = song.releaseDate,
            featuredArtists = song.featuredArtists?.map(ArtistUiModelConverter::convert),
            producers = song.producers?.map(ArtistUiModelConverter::convert),
            artists = song.artists.map(ArtistUiModelConverter::convert),
            isLiked = isLiked,
            isHot = song.isHot,
            pageViewCount = song.pageViewCount,
            coverUrl = song.coverUrl,
            songTextUrl = song.songTextUrl,
        )
    }
}