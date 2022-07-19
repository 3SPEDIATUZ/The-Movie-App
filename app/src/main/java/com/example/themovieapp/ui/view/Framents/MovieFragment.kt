package com.example.themovieapp.ui.view.Framents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ConcatAdapter
import com.example.themovieapp.R
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.databinding.FragmentMovieBinding
import com.example.themovieapp.ui.view.adapters.MovieAdapter
import com.example.themovieapp.ui.view.adapters.MoviesAdapters
import com.example.themovieapp.ui.view.adapters.concat.PopularConcatAdapter
import com.example.themovieapp.ui.view.adapters.concat.TopRatedConcatAdapter
import com.example.themovieapp.ui.view.adapters.concat.UpcomingConcatAdapter
import com.example.themovieapp.ui.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(), MoviesAdapters.OnClickListenerMovie {

    private lateinit var binding: FragmentMovieBinding
    private lateinit var navController: NavController
    //---------------------------------------------
    private lateinit var concatAdapter: ConcatAdapter
    private var moviesAdapters: MoviesAdapters? = null
    private  val movieViewModel: MovieViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //-------------------------------------------
        concatAdapter = ConcatAdapter()
        //-------------------------------------------
        setObservers()
        //-------------------------------------------
        movieViewModel.getMoviePopular()
        movieViewModel.getMovieTopRated()
        movieViewModel.getMovieUpcoming()
        //-------------------------------------------
    }

    private fun setObservers(){
        movieViewModel.successMoviePopular.observe(viewLifecycleOwner, { successPopular ->
            concatAdapter.apply {
                addAdapter(0,PopularConcatAdapter(MoviesAdapters(successPopular.response,this@MovieFragment)))
                moviesAdapters?.submit(successPopular.response)
            }
        })
        movieViewModel.successMovieTopRated.observe(viewLifecycleOwner, { successRated ->
            concatAdapter.apply {
                addAdapter(0,TopRatedConcatAdapter(MoviesAdapters(successRated.response, this@MovieFragment)))
                moviesAdapters?.submit(successRated.response)
            }
        })
        movieViewModel.successMovieUpcoming.observe(viewLifecycleOwner, { successUpcoming ->
            concatAdapter.apply {
                addAdapter(0,UpcomingConcatAdapter(MoviesAdapters(successUpcoming.response,this@MovieFragment)))
                moviesAdapters?.submit(successUpcoming.response)
            }
        })
        movieViewModel.error.observe(viewLifecycleOwner,{
            Log.e("Error","Error en lectura de peliculas")
        })
        movieViewModel.isLoading.observe(viewLifecycleOwner, { isLoading ->
            binding.linearLayoutProgress.isVisible = isLoading
        })
        binding.recyclerViewMovie.adapter = concatAdapter
    }

    override fun onMovieClick(movie: Movie) {
        Log.e("Movie", "onMovieClick: $movie")
        navController = view?.let { Navigation.findNavController(it) }!!
        navController.navigate(
            R.id.action_movieFragment_to_movieDetailFragment,
            bundleOf(
                "background" to movie.background,
                "language" to movie.language,
                "originalTitle" to movie.originalTitle,
                "description" to movie.description,
                "popularity" to movie.popularity,
                "poster" to movie.poster,
                "date" to movie.date,
                "title" to movie.title,
                "voteAverage" to movie.voteAverage,
                "voteCount" to movie.voteCount,
            )
        )
    }
}