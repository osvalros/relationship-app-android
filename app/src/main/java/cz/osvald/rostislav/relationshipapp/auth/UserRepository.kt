package cz.osvald.rostislav.relationshipapp.auth

import cz.osvald.rostislav.relationshipapp.models.UserCredentials
import cz.osvald.rostislav.relationshipapp.service.AuthService

class UserRepository(private val authService: AuthService) {
    suspend fun login(name: String, password: String) =
        authService.login(UserCredentials(name, password))

    suspend fun register(name: String, password: String) =
        authService.register(UserCredentials(name, password))

    suspend fun getMe() = authService.getMe()
}