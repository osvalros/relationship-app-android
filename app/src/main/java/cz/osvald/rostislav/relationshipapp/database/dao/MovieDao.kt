package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie

@Dao
interface MovieDao: BaseDao<Movie> {
    @Query("SELECT * FROM Movie WHERE viewedAt is NULL ORDER BY created")
    fun getMoviesToWatch(): LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE viewedAt is not NULL ORDER BY viewedAt DESC")
    fun getWatchedMovies(): LiveData<List<Movie>>
}
