package cz.osvald.rostislav.relationshipapp.models

data class Rating (
    val id: Int,
    val value: Short,
    val movieId: Int,
    val userId: Int,
)