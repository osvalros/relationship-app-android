package cz.osvald.rostislav.relationshipapp.database.entitity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val name: String,
    var created: LocalDateTime = LocalDateTime.now(),
    var viewedAt: LocalDateTime? = null
) {
    val wasViewed
        get() = viewedAt !== null
}
