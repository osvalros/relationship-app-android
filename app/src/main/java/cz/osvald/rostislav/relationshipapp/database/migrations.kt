package cz.osvald.rostislav.relationshipapp.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            CREATE TABLE Rating(
              id INTEGER PRIMARY KEY AUTOINCREMENT,
              value REAL NOT NULL, 
              user TEXT NOT NULL,
              movieId INTEGER NOT NULL,
              
              FOREIGN KEY(movieId) REFERENCES Movie(id) ON DELETE CASCADE
            );
        """
        )
    }
}

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(""" ALTER TABLE Rating ADD comment TEXT;""")
    }
}


val ALL_MIGRATIONS = arrayOf(MIGRATION_1_2, MIGRATION_2_3)
