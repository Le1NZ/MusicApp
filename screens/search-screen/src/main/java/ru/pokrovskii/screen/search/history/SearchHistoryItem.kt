package ru.pokrovskii.screen.search.history

import com.google.gson.annotations.SerializedName

internal data class SearchHistoryItem(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("coverUrl") val coverUrl: String?,
    @SerializedName("artistName") val artistName: String,
)
