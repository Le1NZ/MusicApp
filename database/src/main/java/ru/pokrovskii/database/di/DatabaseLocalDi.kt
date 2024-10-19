package ru.pokrovskii.database.di

import androidx.room.Room
import org.koin.dsl.module
import ru.pokrovskii.database.db.FavoriteSongsDb

object DatabaseLocalDi {

    val module = module {
        single<FavoriteSongsDb> {
            Room.databaseBuilder(
                context = get(),
                klass = FavoriteSongsDb::class.java,
                name = "favorite_songs",
            ).build()
        }
    }
}