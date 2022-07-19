package com.example.themovieapp.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapp.data.remote.model.MovieModel
import com.example.themovieapp.databinding.ItemMovieBinding
import com.example.themovieapp.utils.BaseViewHolder
import com.example.themovieapp.utils.Constants

class MoviesAdapters (
    private var moviesList: List<MovieModel>,
    private val itemClickListener: OnClickListenerMovie
    ): RecyclerView.Adapter<BaseViewHolder<*>>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        context = parent.context
        val itemBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesHolder((itemBinding))
        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }// takeIf-> significa tomar que. esta linea toma la posición de la lista que se esta clikiando
                    ?: return@setOnClickListener
            itemClickListener.onMovieClick(moviesList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MoviesHolder -> holder.bind(moviesList[position])
        }
    }

    override fun getItemCount(): Int = moviesList.size

    private inner class MoviesHolder(val binding: ItemMovieBinding) :
        BaseViewHolder<MovieModel>(binding.root) {
        override fun bind(item: MovieModel) {
            Glide.with(context)
                .load("${Constants.URL_IMG}${item.poster}").centerCrop()
                .into(binding.imagenViewMovie)
        }
    }

    fun submit(list: List<MovieModel>) {
        moviesList = list
        notifyItemChanged(moviesList.size-1)
    }

    interface OnClickListenerMovie {
        fun onMovieClick(movieModel: MovieModel)
    }
}