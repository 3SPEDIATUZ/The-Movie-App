package com.example.themovieapp.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.view.adapter.MovieAdapter
import com.example.themovieapp.ui.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieAdapter.RecyclerViewHomeClickListener {

    private lateinit var binding: FragmentMovieBinding

    private val movieViewModel: MovieViewModel by viewModels()
    private val movieAdapter: MovieAdapter by lazy { context?.let { MovieAdapter(this, it) }!! }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMainAdapter()
        movieViewModel.getMovie()
        setObservers()
    }

    private fun setMainAdapter() {
        binding.recyclerViewMovie.adapter = movieAdapter
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewMovie.layoutManager = layoutManager
    }

    private fun setObservers() {
        movieViewModel.dataMovie.observe(viewLifecycleOwner, { dataMovie ->
            val data = dataMovie.movieModels
            movieAdapter.submitList(data)
        })
    }

    override fun clickOnItem(data: MovieModel, card: View) {}
}