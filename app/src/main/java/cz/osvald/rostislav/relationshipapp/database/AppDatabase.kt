package cz.osvald.rostislav.relationshipapp.database

import android.content.Context
import androidx.room.*
import cz.osvald.rostislav.relationshipapp.database.dao.MovieDao
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object DateTimeTypeConverters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): LocalDateTime? {
        return value?.let {
            return formatter.parse(value, LocalDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: LocalDateTime?): String? {
        return date?.format(formatter)
    }
}

@Database(entities = [Movie::class], version = 1)
@TypeConverters(DateTimeTypeConverters::class)
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