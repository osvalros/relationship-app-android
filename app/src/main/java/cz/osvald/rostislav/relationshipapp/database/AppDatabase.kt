package cz.osvald.rostislav.relationshipapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.osvald.rostislav.relationshipapp.database.dao.MovieDao
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase = instance ?: synchronized(this) {
            instance ?: Room
                .databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "relationship-app.db"
                )
                .build()
                .also { instance = it }
        }

    }

    abstract fun movieDao(): MovieDao
}