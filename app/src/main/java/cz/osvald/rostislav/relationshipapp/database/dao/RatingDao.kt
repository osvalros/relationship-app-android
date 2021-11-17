package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import cz.osvald.rostislav.relationshipapp.database.entitity.Rating

@Dao
interface RatingDao : BaseDao<Rating> {
    @Query("SELECT * FROM Rating WHERE movieId = :movieId")
    fun getRatingsForMovie(movieId: Int): LiveData<List<Rating>>
}