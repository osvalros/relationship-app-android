package cz.osvald.rostislav.relationshipapp.movie_night

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import cz.osvald.rostislav.relationshipapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

val localDateTimeConverter = object : Converter {
    override fun canConvert(cls: Class<*>): Boolean = cls == LocalDateTime::class.java

    override fun fromJson(jv: JsonValue) = if(jv.string != null) LocalDateTime.parse(jv.string) else null

    override fun toJson(value: Any) = "\"$value\""

}

class MovieNightViewModel(application: Application) : AndroidViewModel(application) {
    companion object {
        const val MOVIES_SHARED_PREFERENCES_KEY = "MOVIES_SHARED_PREFERENCES_KEY"
    }

    private val sharedPreferences by lazy {
        application.getSharedPreferences(
            application.getString(R.string.movie_night_shared_preferences),
            Context.MODE_PRIVATE
        )
    }

    private val klaxon by lazy {
        Klaxon().converter(localDateTimeConverter)
    }

    private val movies: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>().also {
//            loadMovies()
        }
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movies
    }

    private fun getMovieListFromSharedPreferences(movieListString: String) =
        klaxon.parseArray<Movie>(movieListString) ?: emptyList()

    fun loadMovies() {
        val moviesString = sharedPreferences.getString(MOVIES_SHARED_PREFERENCES_KEY, null) ?: "[]"
        movies.value = getMovieListFromSharedPreferences(moviesString)
    }

    fun addMovie(movie: Movie) {
        val moviesString = sharedPreferences.getString(MOVIES_SHARED_PREFERENCES_KEY, null) ?: "[]"
        val movieList: List<Movie> = getMovieListFromSharedPreferences(moviesString) + movie
            with(sharedPreferences.edit()) {
            putString(MOVIES_SHARED_PREFERENCES_KEY, klaxon.toJsonString(movieList))
            apply()
        }
        movies.value = movieList
    }
}
