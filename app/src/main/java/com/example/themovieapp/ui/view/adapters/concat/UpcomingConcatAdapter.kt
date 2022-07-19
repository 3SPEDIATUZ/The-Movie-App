package com.example.themovieapp.ui.view.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.databinding.UpcomingMovieRowBinding
import com.example.themovieapp.ui.view.adapters.MoviesAdapters
import com.example.themovieapp.utils.BaseConcatHolder

class UpcomingConcatAdapter(private val moviesAdapters: MoviesAdapters): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
       val itemBinding = UpcomingMovieRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapters)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder (val binding: UpcomingMovieRowBinding): BaseConcatHolder<MoviesAdapters>(binding.root){
        override fun bind(adapter: MoviesAdapters) {
            binding.recyclerViewUpcomingMovie.adapter = adapter
        }

    }
}