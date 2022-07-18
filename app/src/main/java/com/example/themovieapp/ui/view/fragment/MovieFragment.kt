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
import com.example.themovieapp.data.local.entity.movieToMovieEntity
import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.domain.model.listMovieModelToListMovie
import com.example.themovieapp.ui.view.adapter.MovieAdapter
import com.example.themovieapp.ui.viewModel.MovieViewModel
import com.example.themovieapp.utils.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
        movieViewModel.onMovies()
        setObservers()
    }

    private fun setMainAdapter() {
        binding.recyclerViewMovie.adapter = movieAdapter
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewMovie.layoutManager = layoutManager
    }

    private fun setObservers() {
        movieViewModel.movie.observe(viewLifecycleOwner, { movieResponse ->
            when(movieResponse) {
                is Result.Success -> {
                    lifecycleScope.launch { movieAdapter.submitList(movieResponse.data) }

                }
                is Result.Error -> {
                    Log.e("Hola", "Aqui esta")
                }
            }
        })
    }
    /*private fun setObservers() {
        movieViewModel.movie.observe(viewLifecycleOwner, { movieResponse ->
           when(movieResponse) {
               is Result.Success -> {
                   movieAdapter.submitList(movieResponse.data.movieModels.listMovieModelToListMovie())
               }
               is Result.Error -> {
                   Log.e("Hola", "Aqui esta")
               }
           }
        })
    }*/

    /*private fun setObservers() {
        movieViewModel.movie.observe(viewLifecycleOwner, { movieResponse ->
           when(movieResponse) {
               is Result.Success -> {
                   movieAdapter.submitList(movieResponse.data)
               }
               is Result.Error -> {
                   Log.e("Hola", "Aqui esta")
               }
           }
        })
    }*/

    override fun clickOnItem(data: Movie, card: View) {}
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