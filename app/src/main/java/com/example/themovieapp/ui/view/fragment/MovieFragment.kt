package com.example.themovieapp.ui.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.view.adapter.MovieAdapter
import com.example.themovieapp.ui.viewModel.MovieViewModel
import com.hadiyarajesh.flower.Resource
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
        movieViewModel.getMovies()
        setObservers()
    }

    private fun setMainAdapter() {
        binding.recyclerViewMovie.adapter = movieAdapter
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewMovie.layoutManager = layoutManager
    }

    private fun setObservers() {
        movieViewModel.quoteModel.observe(viewLifecycleOwner, {
           //movieAdapter.submitList(it)
            Log.e("hola", "Aqui esta $it")
        })
    }

    override fun clickOnItem(data: MovieModel, card: View) {}
}

/*private fun setObservers() {
        lifecycleScope.launchWhenCreated {
            movieViewModel.dataMovie.collect { response ->
                when (response.status) {
                    Resource.Status.SUCCESS -> {
                        movieAdapter.submitList(response.data!!.movieModels)
                        Log.e("Hola", "SUCCESS")
                    }
                     Resource.Status.ERROR("Error", 400) -> {
                         Log.e("Hola", "ERROR")
                     }
                    Resource.Status.LOADING -> {
                        Log.e("Hola", "LOADING")
                    }
                    else -> {}
                }
            }
        }
    }*/