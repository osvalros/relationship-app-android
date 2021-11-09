package cz.osvald.rostislav.relationshipapp.movie_night

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cz.osvald.rostislav.relationshipapp.databinding.MovieItemBinding

class MovieListRecyclerViewAdapter(
    private val values: List<Movie>,
    private val viewModel: MovieNightViewModel,
) : RecyclerView.Adapter<MovieListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.binding.name.text = item.name
        holder.binding.removeMovieButton.setOnClickListener { viewModel.addMovie() }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        override fun toString(): String {
            return super.toString() + " '" + nameView.text + "'"
        }
    }
}