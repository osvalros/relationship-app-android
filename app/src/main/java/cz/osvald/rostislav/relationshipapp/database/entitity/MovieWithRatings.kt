package cz.osvald.rostislav.relationshipapp.database.entitity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithRatings(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val ratings: List<Rating>
)