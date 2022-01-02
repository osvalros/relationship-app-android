package cz.osvald.rostislav.relationshipapp.service

import cz.osvald.rostislav.relationshipapp.utils.SharedPreferencesUtil
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    private val sharedPreferencesUtil = SharedPreferencesUtil()

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sharedPreferencesUtil.getAuthToken()?.let { token ->
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        return chain.proceed(requestBuilder.build())
    }
}