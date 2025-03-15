package ru.pokrovskii.screen.search.history

import ru.pokrovskii.model.song.MinimizedSong

internal object SearchHistoryItemConverter {

    fun toSearchHistoryItem(song: MinimizedSong): SearchHistoryItem {
        return SearchHistoryItem(
            id = song.id,
            title = song.title,
            coverUrl = song.coverUrl,
            artistName = song.artistName,
        )
    }

    fun toMinimizedSong(searchHistoryItem: SearchHistoryItem): MinimizedSong {
        return MinimizedSong(
            id = searchHistoryItem.id,
            title = searchHistoryItem.title,
            coverUrl = searchHistoryItem.coverUrl,
            artistName = searchHistoryItem.artistName,
        )
    }
}