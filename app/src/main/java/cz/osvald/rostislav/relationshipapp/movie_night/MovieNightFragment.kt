package cz.osvald.rostislav.relationshipapp.movie_night

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cz.osvald.rostislav.relationshipapp.LOG_TAG
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.database.entitity.Movie
import cz.osvald.rostislav.relationshipapp.databinding.DialogAddMovieBinding
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMovieNightBinding
import cz.osvald.rostislav.relationshipapp.utils.Dialoger

class MovieNightFragment : Fragment() {

    private lateinit var binding: FragmentMovieNightBinding

    companion object {
        fun newInstance() = MovieNightFragment()
    }

    private val viewModel: MovieNightViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentMovieNightBinding.inflate(inflater, container, false)
        binding.addMovieButton.setOnClickListener {
            context?.let { context -> Dialoger.addMovieDialog(context, viewModel) }
        }
        val activity = activity
        if (activity is AppCompatActivity) {
            activity.setSupportActionBar(binding.toolbar)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getMoviesToWatch().observe(viewLifecycleOwner, { movieList ->
            Log.i(LOG_TAG, "Movies observer called ($movieList)")
            binding.movieList.list.adapter = MovieListRecyclerViewAdapter(movieList, viewModel)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_movie_night, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_history -> {
                findNavController().navigate(
                    MovieNightFragmentDirections.actionMovieNightFragmentToMovieNightHistoryFragment()
                )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}