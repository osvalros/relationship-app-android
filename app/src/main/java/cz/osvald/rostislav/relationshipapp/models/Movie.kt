package cz.osvald.rostislav.relationshipapp.models

data class Movie(
    val id: Int,
    val name: String,
    val createdAt: String?,
    val viewedAt: String?
)