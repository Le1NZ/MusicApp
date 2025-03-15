package ru.pokrovskii.storage.api

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

interface DataStoreProvider {

    fun getStorage(name: String): DataStore<Preferences>
}