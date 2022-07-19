package com.example.themovieapp.ui.view.Framents

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.themovieapp.databinding.FragmentMovieDetailBinding
import com.example.themovieapp.ui.viewModel.MovieDetailViewModel
import com.example.themovieapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val movieDetailViewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()
    }

    private fun setContent(){
        arguments?.let { bundle ->
            Glide.with(requireContext())
                .load("${Constants.URL_IMG}${bundle.getString("background")}").centerCrop()
                .into(binding.imagenViewBackground)
            Glide.with(requireContext())
                .load("${Constants.URL_IMG}${bundle.getString("poster")}").centerCrop()
                .into(binding.imagenViewPoster)
            binding.textViewTilte.text = bundle.getString("title")
            binding.textViewRating.text ="${bundle.getFloat("voteAverage")} (${bundle.getFloat("popularity")} Reviews)"
            binding.textViewReleased.text = "Released ${bundle.getString("date")}"
            binding.textViewLanguage.text = "Language ${bundle.getString("language")}"
            binding.textViewOverview.text = bundle.getString("originalTitle")
            binding.textViewDescription.text = bundle.getString("description")
        }

    }
}