package ru.pokrovskii.design.theme

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.map
import ru.pokrovskii.design.theme.api.AppThemeState
import ru.pokrovskii.storage.api.DataStoreProvider

internal class AppThemeStorage(
    private val dataStoreProvider: DataStoreProvider,
) {
    private val storage by lazy {
        dataStoreProvider.getStorage(
            name = STORAGE_NAME,
        )
    }

    val state = storage.data
        .map { preferences ->
            val themeNumber = preferences[storageKey()]

            themeNumber?.let { currentThemeNumber ->
                AppThemeState.entries[currentThemeNumber]
            } ?: AppThemeState.SYSTEM
        }

    suspend fun setState(state: AppThemeState) {
        storage.edit { preferences ->
            preferences[storageKey()] = state.ordinal
        }
    }

    private fun storageKey() = intPreferencesKey(STORAGE_KEY)

    companion object {

        private const val STORAGE_NAME = "AppThemeStorage"
        private const val STORAGE_KEY = "AppThemeKey"
    }
}