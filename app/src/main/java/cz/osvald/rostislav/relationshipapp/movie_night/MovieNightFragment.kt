package cz.osvald.rostislav.relationshipapp.movie_night

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cz.osvald.rostislav.relationshipapp.R
import cz.osvald.rostislav.relationshipapp.databinding.DialogAddMovieBinding
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMovieNightBinding

class MovieNightFragment : Fragment() {

    private lateinit var binding: FragmentMovieNightBinding

    companion object {
        fun newInstance() = MovieNightFragment()
    }

    private lateinit var viewModel: MovieNightViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieNightBinding.inflate(inflater, container, false)
        binding.addMovieButton.setOnClickListener {
            val dialogBinding = DialogAddMovieBinding.inflate(inflater)
            activity?.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setView(dialogBinding.root)
                    setPositiveButton(R.string.ok) { dialog, _ ->
                        val name = dialogBinding.name.text.toString()
                        if (name.isNotBlank()) {
                            viewModel.addMovie(Movie(name))
                        }
                    }
                    setNegativeButton(R.string.cancel) { dialog, _ -> dialog.cancel() }
                }
                builder.create()
            }?.show()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieNightViewModel::class.java)
        viewModel.getMovies().observe(viewLifecycleOwner, { movieList ->
            binding.movieList.list.adapter = MovieListRecyclerViewAdapter(
                movieList.filter { movie -> !movie.wasViewed }.sortedBy { movie -> movie.created }
            )
        })
    }

    override fun onResume() {
        viewModel.loadMovies()
        super.onResume()
    }
}