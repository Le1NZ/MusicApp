package ru.pokrovskii.database.di

import androidx.room.Room
import org.koin.dsl.module
import ru.pokrovskii.database.api.FavoritesSongsLocalRepository
import ru.pokrovskii.database.db.FavoriteSongsDb
import ru.pokrovskii.database.impl.FavoritesSongsLocalRepositoryImpl
import ru.pokrovskii.database.migration.Migrations

object DatabaseDi {

    val module = module {
        single<FavoriteSongsDb> {
            Room.databaseBuilder(
                context = get(),
                klass = FavoriteSongsDb::class.java,
                name = "favorite_songs",
            )
                .addMigrations(Migrations.MIGRATION_1_2)
                .build()
        }

        single<FavoritesSongsLocalRepository> {
            FavoritesSongsLocalRepositoryImpl(
                dao = get<FavoriteSongsDb>().dao(),
            )
        }
    }
}