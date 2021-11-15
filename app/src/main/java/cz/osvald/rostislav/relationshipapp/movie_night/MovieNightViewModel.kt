package cz.osvald.rostislav.relationshipapp.movie_night

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.database.AppDatabase
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MovieNightViewModel(application: Application) : AndroidViewModel(application) {
    private val movieDao by lazy {
        AppDatabase.getInstance(application).movieDao()
    }

    fun getMoviesToWatch() = movieDao.getMoviesToWatch()

    fun getWatchedMovies() = movieDao.getWatchedMovies()

    fun addMovie(movie: Movie) = viewModelScope.launch { movieDao.insert(movie) }

    fun updateMovie(movie: Movie) = viewModelScope.launch { movieDao.update(movie) }

    fun deleteMovie(movie: Movie) = viewModelScope.launch { movieDao.delete(movie) }
}
