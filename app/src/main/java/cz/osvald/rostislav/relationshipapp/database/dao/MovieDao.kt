package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie

@Dao
interface MovieDao: BaseDao<Movie> {
    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM movie WHERE viewedAt = NULL")
    fun getMoviesToWatch(): List<Movie>

    @Query("SELECT * FROM movie WHERE viewedAt <> NULL")
    fun getWatchedMovies(): List<Movie>

}