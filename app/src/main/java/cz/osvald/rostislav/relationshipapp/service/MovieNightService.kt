package cz.osvald.rostislav.relationshipapp.service

import cz.osvald.rostislav.relationshipapp.models.*
import retrofit2.Response
import retrofit2.http.*

interface MovieNightService {
    @GET("/movies")
    suspend fun getAllMovies(): Response<List<Movie>>

    @POST("/movies")
    suspend fun createMovie(@Body body: CreateMovieBody): Response<Void>

    @GET("/movies/{id}")
    suspend fun getMovieById(@Path("id") id: Int): Response<Movie>

    @PUT("/movies/{id}")
    suspend fun editMovie(@Path("id") id: Int, @Body body: EditMovieBody): Response<Void>

    @GET("/movies/{id}/ratings")
    suspend fun getRatingsForMovie(@Path("id") id: Int): Response<List<Rating>>

    @POST("/movies/{id}/ratings")
    suspend fun rateMovie(@Path("id") id: Int, @Body body: RateMovieBody): Response<List<Rating>>
}
