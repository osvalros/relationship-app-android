package cz.osvald.rostislav.relationshipapp.movie_night

import java.time.LocalDateTime

data class Movie(
    val name: String,
    var created: LocalDateTime = LocalDateTime.now(),
    var viewedAt: LocalDateTime? = null
) {
    val wasViewed
        get() = viewedAt !== null
}
