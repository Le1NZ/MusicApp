package ru.pokrovskii.network.utils

import android.util.Log
import retrofit2.Call
import retrofit2.awaitResponse
import ru.pokrovskii.model.result.DataOrError
import ru.pokrovskii.network.BackendResponse

internal suspend fun <T, R> Call<BackendResponse<T>>.toResult(
    mapper: T.() -> R,
): DataOrError<R> {
    return try {
        val response = this.awaitResponse()
        if (response.isSuccessful) {
            DataOrError.Data(
                data = response.body()?.response?.mapper() ?: return DataOrError.Error
            )
        } else {
            DataOrError.Error
        }
    } catch (e: Exception) {
        DataOrError.Error
    }
}

internal suspend fun <T, R> Call<T>.toSimpleResult(
    mapper: T.() -> R,
): DataOrError<R> {
    return try {
        val response = this.awaitResponse()
        if (response.isSuccessful) {
            DataOrError.Data(
                data = response.body()?.mapper() ?: return DataOrError.Error
            )
        } else {
            DataOrError.Error
        }
    } catch (e: Exception) {
        Log.d("testing", "error: $e")
        DataOrError.Error
    }
}