package cz.osvald.rostislav.relationshipapp.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import cz.osvald.rostislav.relationshipapp.databinding.DialogAddMovieBinding
import cz.osvald.rostislav.relationshipapp.databinding.DialogRateMovieBinding
import cz.osvald.rostislav.relationshipapp.movie_night.MovieNightViewModel
import java.time.LocalDateTime

object Dialoger {
    fun addMovieDialog(context: Context, viewModel: MovieNightViewModel) {
        val dialogBinding = DialogAddMovieBinding.inflate(LayoutInflater.from(context))
        val dialog = AlertDialog.Builder(context).apply {
            setView(dialogBinding.root)
            setPositiveButton(R.string.ok) { _, _ ->
                val name = dialogBinding.name.text.toString()
                if (name.isNotBlank()) {
                    viewModel.addMovie(Movie(name = name))
                }
            }
            setNegativeButton(R.string.cancel) { _, _ -> }
        }.create()
        dialog.show()
    }

    fun editMovieDialog(context: Context, viewModel: MovieNightViewModel, movie: Movie) {
        val dialogBinding = DialogAddMovieBinding.inflate(LayoutInflater.from(context))
        dialogBinding.name.isEnabled = false
        dialogBinding.name.setText(movie.name)
        val dialog = AlertDialog.Builder(context).apply {
            setView(dialogBinding.root)
            setNeutralButton(R.string.delete) { _, _ -> viewModel.deleteMovie(movie)}
            if (movie.viewedAt == null) {
                setPositiveButton(R.string.seen) { _, _ ->
                    movie.viewedAt = LocalDateTime.now()
                    viewModel.updateMovie(movie)
                }
            }
            setNegativeButton(R.string.cancel) { _, _ -> }
        }.create()
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(context.getColor(R.color.red))
    }
}