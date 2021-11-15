package cz.osvald.rostislav.relationshipapp.movie_night

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import cz.osvald.rostislav.relationshipapp.LOG_TAG
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMovieNightBinding
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMovieNightHistoryBinding
import java.time.LocalDateTime

class MovieNightHistoryFragment : Fragment() {
    private lateinit var binding: FragmentMovieNightHistoryBinding

    companion object {
        fun newInstance() = MovieNightHistoryFragment()
    }

    private lateinit var viewModel: MovieNightViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieNightHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieNightViewModel::class.java)
        viewModel.getWatchedMovies().observe(viewLifecycleOwner, { movieList ->
            Log.i(LOG_TAG, "Movies observer called ($movieList)")
            binding.movieList.list.adapter = MovieListRecyclerViewAdapter(movieList, viewModel)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.addMovie(Movie(name="MovieNightHistoryFragment"+LocalDateTime.now()))
    }
}