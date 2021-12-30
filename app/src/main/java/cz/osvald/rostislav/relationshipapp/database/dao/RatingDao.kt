package cz.osvald.rostislav.relationshipapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import cz.osvald.rostislav.relationshipapp.database.entitity.Rating
import kotlinx.coroutines.flow.Flow

@Dao
interface RatingDao : BaseDao<Rating> {
    @Query("SELECT * FROM Rating WHERE movieId = :movieId")
    fun getRatingsForMovie(movieId: Int): Flow<List<Rating>>
}