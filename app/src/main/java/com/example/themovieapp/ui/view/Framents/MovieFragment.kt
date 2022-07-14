package com.example.themovieapp.ui.view.Framents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.view.adapters.MovieAdapter
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
        movieViewModel.getMoviePopular()
        movieViewModel.getMovieTopRated()
        movieViewModel.getMovieUpcoming()
        setMovieAdapter()
    }

    private fun setMovieAdapter() {
        movieAdapter = MovieAdapter(this)
        binding.recyclerViewMovie.adapter = movieAdapter
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMovie.layoutManager = linearLayoutManager
        movieAdapter.notifyDataSetChanged()
    }

    fun setObservers(){
        movieViewModel.isSuccessMoviePopular.observe(viewLifecycleOwner, { isSuccess ->
            Log.e("Hola", "Aqui esta movie popular: $isSuccess")
            movieAdapter.submit(isSuccess.response)
        })
        movieViewModel.isSuccessMovieTopRated.observe(viewLifecycleOwner, { isSuccess ->
            Log.e("Hola2", "Aqui esta movie Top Rated: $isSuccess")
            movieAdapter.submit(isSuccess.response)
        })
        movieViewModel.isSuccessMovieUpcoming.observe(viewLifecycleOwner, { isSucces ->
            Log.e("Hola3", "Aqui esta movie Upcoming: $isSucces")
            movieAdapter.submit(isSucces.response)
        })
        movieViewModel.error.observe(viewLifecycleOwner,{
            Log.e("Error","Error en lectura de peliculas")
        })
    }

    override fun onClick(movie: Movie) {

    }
}