package ru.pokrovskii.network.artist.dto

import com.google.gson.annotations.SerializedName

data class FullArtistDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val coverUrl: String?,
    @SerializedName("alternate_names") val aka: List<String>?,
    @SerializedName("followers_count") val followersCount: Long?,
)

