package ru.pokrovskii.storage.provider

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import ru.pokrovskii.storage.api.DataStoreProvider

internal class DataStoreProviderImpl(
    private val context: Application,
) : DataStoreProvider {

    override fun getStorage(name: String): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile(name)
        }
    }
}