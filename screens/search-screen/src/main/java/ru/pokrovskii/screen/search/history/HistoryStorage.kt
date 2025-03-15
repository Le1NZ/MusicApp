package ru.pokrovskii.screen.search.history

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import ru.pokrovskii.model.song.MinimizedSong
import ru.pokrovskii.storage.api.DataStoreProvider

internal class HistoryStorage(
    private val dataStoreProvider: DataStoreProvider,
) {

    private val gson = Gson()
    private val serializationType by lazy {
        object : TypeToken<List<SearchHistoryItem>>() {}.type
    }

    private val storage by lazy {
        dataStoreProvider.getStorage(
            name = STORAGE_NAME,
        )
    }

    private val historyItems = storage.data
        .map { preferences ->
            val json = preferences[storageKey()]
            if (json.isNullOrEmpty()) {
                emptyList()
            } else {
                gson.fromJson<List<SearchHistoryItem>>(json, serializationType) ?: emptyList()
            }
        }

    val searchHistory = historyItems
        .map { list ->
            list.map(SearchHistoryItemConverter::toMinimizedSong)
        }

    suspend fun addToHistory(song: MinimizedSong) {
        val currentHistory = historyItems.first().toMutableList()
        val searchItem = SearchHistoryItemConverter.toSearchHistoryItem(song)

        currentHistory.remove(searchItem) // remove if it is in history already
        currentHistory.add(
            index = 0,
            element = searchItem,
        )
        val newHistory = currentHistory.take(MAX_HISTORY_SIZE)

        storage.edit { preferences ->
            val json = gson.toJson(newHistory)
            preferences[storageKey()] = json
        }
    }

    suspend fun clearHistory() {
        storage.edit { preferences ->
            val json = gson.toJson(emptyList<MinimizedSong>())
            preferences[storageKey()] = json
        }
    }

    private fun storageKey() = stringPreferencesKey(STORAGE_KEY)

    companion object {

        private const val STORAGE_NAME = "SearchHistoryStorage"
        private const val STORAGE_KEY = "SearchHistoryKey"

        private const val MAX_HISTORY_SIZE = 10
    }
}