package cz.osvald.rostislav.relationshipapp.movie_night

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import cz.osvald.rostislav.relationshipapp.FRAGMENT_LOG_TAG
import cz.osvald.rostislav.relationshipapp.LOG_TAG
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMovieNightHistoryBinding
import kotlinx.coroutines.flow.collect


class MovieNightHistoryFragment : Fragment() {
    private lateinit var binding: FragmentMovieNightHistoryBinding

    companion object {
        fun newInstance() = MovieNightHistoryFragment()
    }

//    private val viewModel: MovieNightViewModel by activityViewModels()
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
        lifecycle.coroutineScope.launchWhenStarted {
            viewModel.getWatchedMovies().collect { movieList ->
                Log.i(FRAGMENT_LOG_TAG, "Movies observer called ($movieList)")
                binding.movieList.list.adapter = MovieListRecyclerViewAdapter(movieList, viewModel)
            }
        }
    }
}