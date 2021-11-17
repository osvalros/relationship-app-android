package cz.osvald.rostislav.relationshipapp.database.entitity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Movie::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("movieId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Rating(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val movieId: Int,
    val value: Double,
    val user: String, // TODO later turn into actual user object
)
