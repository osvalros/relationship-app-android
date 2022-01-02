package cz.osvald.rostislav.relationshipapp.service

import cz.osvald.rostislav.relationshipapp.models.LoginResponse
import cz.osvald.rostislav.relationshipapp.models.User
import cz.osvald.rostislav.relationshipapp.models.UserCredentials
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("/login")
    suspend fun login(@Body body: UserCredentials): Response<LoginResponse>

    @POST("/register")
    suspend fun register(@Body body: UserCredentials): Response<Void>

    @GET("/users/me")
    suspend fun getMe(): Response<User>
}
