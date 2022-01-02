package cz.osvald.rostislav.relationshipapp.service

import com.google.gson.*
import cz.osvald.rostislav.relationshipapp.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LocalDateTimeGsonTypeAdapter : JsonSerializer<LocalDateTime?>,
    JsonDeserializer<LocalDateTime?> {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    override fun serialize(
        src: LocalDateTime?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src?.format(formatter))
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDateTime? {
        return json?.asString?.let {
            return formatter.parse(it, LocalDateTime::from)
        }
    }
}

object ApiClient {
    private val gson: Gson by lazy {
        GsonBuilder()
            .setLenient()
            .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeGsonTypeAdapter)
            .create()
    }

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val movieNightService: MovieNightService by lazy {
        retrofit.create(MovieNightService::class.java)
    }

    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }
}
