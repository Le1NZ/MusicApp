package ru.pokrovskii.model.song

data class MinimizedSong(
    val id: Int,
    val title: String,
    val coverUrl: String?,
    val artistName: String,
) {

    companion object {

        fun forPreview(): MinimizedSong {
            return MinimizedSong(
                id = 0,
                coverUrl = "null",
                title = "Song title",
                artistName = "Artist name",
            )
        }
    }
}