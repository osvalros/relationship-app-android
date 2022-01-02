package cz.osvald.rostislav.relationshipapp.movie_night

import cz.osvald.rostislav.relationshipapp.models.CreateMovieBody
import cz.osvald.rostislav.relationshipapp.models.EditMovieBody
import cz.osvald.rostislav.relationshipapp.models.RateMovieBody
import cz.osvald.rostislav.relationshipapp.service.MovieNightService
import java.time.LocalDateTime

class MovieRepository(private val movieNightService: MovieNightService) {
    suspend fun getAllMovies() = movieNightService.getAllMovies()

    suspend fun createMovie(name: String) = movieNightService.createMovie(CreateMovieBody(name))

    suspend fun getMovieById(id: Int) = movieNightService.getMovieById(id)

    suspend fun editMovie(id: Int, name: String, viewedAt: LocalDateTime) =
        movieNightService.editMovie(id, EditMovieBody(name, viewedAt))

    suspend fun getRatingsForMovie(id: Int) = movieNightService.getRatingsForMovie(id)

    suspend fun rateMovie(id: Int, value: Short) =
        movieNightService.rateMovie(id, RateMovieBody(value))
}