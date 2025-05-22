package ru.pokrovskii.auth.storage

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson
import kotlinx.coroutines.flow.map
import ru.pokrovskii.storage.api.DataStoreProvider

internal class UserStorage(
    storageProvider: DataStoreProvider,
) {
    private val storage = storageProvider.getStorage(USER_STORAGE_NAME)
    private val key by lazy { stringPreferencesKey(USER_KEY) }
    private val gson by lazy { Gson() }

    val user by lazy {
        storage
            .data
            .map { it[key] }
            .map { userJson ->
                try {
                    gson.fromJson(userJson, UserStorageModel::class.java)
                } catch (_: Exception) {
                    null
                }
            }
    }

    suspend fun setUser(userStorageModel: UserStorageModel) {
        val userJson = gson.toJson(userStorageModel)
        storage.edit {
            it[key] = userJson
        }
    }

    suspend fun clearUser() {
        storage.edit { it.clear() }
    }

    companion object {

        private const val USER_STORAGE_NAME = "user_storage"
        private const val USER_KEY = "user"
    }
}