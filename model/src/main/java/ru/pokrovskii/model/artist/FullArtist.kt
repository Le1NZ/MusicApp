package ru.pokrovskii.model.artist

data class FullArtist(
    val id: String,
    val name: String,
    val coverUrl: String?,
    val aka: List<String>?,
    val followersCount: Long?,
)
