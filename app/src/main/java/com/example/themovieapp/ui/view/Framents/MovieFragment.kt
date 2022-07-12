package com.example.themovieapp.ui.view.Framents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.view.adapter.MovieAdapter
import com.example.themovieapp.ui.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MovieAdapter.OnClickListener {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var navController: NavController
    private lateinit var movieAdapter: MovieAdapter
    private  val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        movieViewModel.getMovie()
        setMainAdapter()
    }

    private fun setMainAdapter() {
        movieAdapter = MovieAdapter(this)
        binding.recyclerViewMovie.adapter = movieAdapter
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMovie.layoutManager = linearLayoutManager
        movieAdapter.notifyDataSetChanged()
    }

    private fun setObservers() {
        movieViewModel.isSuccess.observe(viewLifecycleOwner, { isSuccess ->
            Log.e("Hola", "Aqui esta: $isSuccess")
            movieAdapter.submit(isSuccess.response)
        })
    }

    override fun onClick(movie: Movie) {

    }


}