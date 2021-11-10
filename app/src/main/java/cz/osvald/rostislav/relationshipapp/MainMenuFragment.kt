package cz.osvald.rostislav.relationshipapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cz.osvald.rostislav.relationshipapp.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        binding.crossroadsMovieNightButton.setOnClickListener {
            navController.navigate(MainMenuFragmentDirections.actionMainMenuFragmentToMovieNightGraph())
        }
        return binding.root
    }
}