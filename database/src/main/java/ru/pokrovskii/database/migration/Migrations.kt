package ru.pokrovskii.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

internal object Migrations {

    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE favorite_songs ADD COLUMN timestamp INTEGER NOT NULL DEFAULT ${System.currentTimeMillis()}")
        }
    }
}