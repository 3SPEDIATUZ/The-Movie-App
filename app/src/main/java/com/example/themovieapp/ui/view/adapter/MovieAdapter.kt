package com.example.themovieapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapp.R
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.databinding.ItemMainBinding
import com.example.themovieapp.utils.Constants.URL_IMG

class MovieAdapter(private val onClickListener: OnClickListener) :RecyclerView.Adapter<MovieAdapter.MainHolder>() {

    private var itemMovie: List<Movie> = ArrayList()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val movie = itemMovie[position]
        with(holder) {
            holder.bind(movie)
            itemMainBinding.textViewTitle.text = movie.title
            Glide.with(context)
                .load("$URL_IMG${movie.poster}")
                .into(holder.itemMainBinding.imageViewPoster)
        }
    }

    fun submit(list: List<Movie>){
        itemMovie = list
        notifyItemChanged(itemMovie.size-1)
    }

    override fun getItemCount(): Int = itemMovie.size

    inner class MainHolder(view: View) :
        RecyclerView.ViewHolder(view) {
         val itemMainBinding = ItemMainBinding.bind(view)
        fun bind(movie: Movie) {
            itemMainBinding.root.setOnClickListener {
                onClickListener.onClick(movie)
            }
        }
    }

    interface OnClickListener {
        fun onClick(movie: Movie)
    }
}