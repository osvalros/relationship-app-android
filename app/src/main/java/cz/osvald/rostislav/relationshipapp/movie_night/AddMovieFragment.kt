package cz.osvald.rostislav.relationshipapp.movie_night

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.osvald.rostislav.relationshipapp.databinding.FragmentAddMovieBinding

class AddMovieFragment : Fragment() {
    private lateinit var binding: FragmentAddMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun submit() {

    }
}