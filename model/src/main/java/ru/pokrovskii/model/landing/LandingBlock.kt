package ru.pokrovskii.model.landing

data class LandingBlock(
    val id: String,
    val title: String,
    val songs: List<LandingSong>,
)
