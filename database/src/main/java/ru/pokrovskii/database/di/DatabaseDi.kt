package ru.pokrovskii.database.di

import androidx.room.Room
import org.koin.dsl.module
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.database.db.FavoriteSongsDb
import ru.pokrovskii.database.impl.FavoritesSongsLocalRepositoryImpl

object DatabaseDi {

    val module = module {
        single<FavoriteSongsDb> {
            Room.databaseBuilder(
                context = get(),
                klass = FavoriteSongsDb::class.java,
                name = "favorite_songs",
            ).build()
        }

        single<FavoritesSongsLocalRepository> {
            FavoritesSongsLocalRepositoryImpl(
                dao = get<FavoriteSongsDb>().dao(),
            )
        }
    }
}