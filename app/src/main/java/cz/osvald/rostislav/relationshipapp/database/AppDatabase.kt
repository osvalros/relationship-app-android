package cz.osvald.rostislav.relationshipapp.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.osvald.rostislav.relationshipapp.database.dao.MovieDao
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}