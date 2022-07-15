package com.example.themovieapp.ui.view.adapters.concat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.databinding.PopularMovieRowBinding
import com.example.themovieapp.ui.view.adapters.MovieAdapter
import com.example.themovieapp.ui.view.adapters.MoviesAdapters
import com.example.themovieapp.utils.BaseConcatHolder

class PopularConcatAdapter (private val movieAdapter: MoviesAdapters) : RecyclerView.Adapter<BaseConcatHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = PopularMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(movieAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder (val binding: PopularMovieRowBinding): BaseConcatHolder<MoviesAdapters>(binding.root){
        override fun bind(adapter: MoviesAdapters) {
            binding.recylerViewPopularMovie.adapter = adapter
        }

    }
}