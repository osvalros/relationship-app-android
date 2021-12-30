package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao: BaseDao<Movie> {
    @Query("SELECT * FROM Movie WHERE viewedAt is NULL ORDER BY created")
    fun getMoviesToWatch(): Flow<List<Movie>>

    @Query("SELECT * FROM Movie WHERE viewedAt is not NULL ORDER BY viewedAt DESC")
    fun getWatchedMovies(): Flow<List<Movie>>
}
