package ru.pokrovskii.database.api

import org.koin.dsl.module
import ru.pokrovskii.database.db.FavoriteSongsDb
import ru.pokrovskii.database.impl.FavoritesSongsLocalRepositoryImpl

object DatabaseDi {

    val module = module {
        single<FavoritesSongsLocalRepository> {
            FavoritesSongsLocalRepositoryImpl(
                dao = get<FavoriteSongsDb>().dao(),
            )
        }
    }
}