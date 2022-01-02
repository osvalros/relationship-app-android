package cz.osvald.rostislav.relationshipapp.models

import java.time.LocalDateTime

data class Movie(
    val id: Int,
    val name: String,
    val createdAt: LocalDateTime,
    val viewedAt: LocalDateTime?
)