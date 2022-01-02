package cz.osvald.rostislav.relationshipapp.models

import java.time.LocalDateTime

data class EditMovieBody(
    val name: String,
    val viewedAt: LocalDateTime,
)
