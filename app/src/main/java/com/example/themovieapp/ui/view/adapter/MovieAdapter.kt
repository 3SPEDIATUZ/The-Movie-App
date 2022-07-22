package com.example.themovieapp.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import coil.imageLoader
import coil.request.ImageRequest
import com.example.themovieapp.R
import com.example.themovieapp.databinding.ItemMovieBinding
import com.example.themovieapp.domain.model.Movie
import com.example.themovieapp.utils.Constants.IMAGE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieAdapter(
    private val recyclerViewHome: RecyclerViewHomeClickListener,
    private val context: Context
) :
    RecyclerView.Adapter<MovieAdapter.MainViewHolder>() {

    private lateinit var recyclerView: RecyclerView
    private var movieModels: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = movieModels[position]
        item.let {
            holder.apply {
                bind(item, context)
                itemView.tag = item
            }
        }
        holder.itemView.setOnClickListener {
            recyclerViewHome.clickOnItem(item, holder.itemView)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    override fun getItemCount(): Int = movieModels.size

    suspend fun submitList(itemList: List<Movie>) = withContext(Dispatchers.Main) {
        movieModels = itemList
        notifyItemInserted(movieModels.size - 1)
    }

    class MainViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, context: Context) {
            val imageRequest = ImageRequest.Builder(context)
                .data("$IMAGE_URL${movie.poster}")
                .crossfade(true)
                .size(1280, 720)
                .target(
                    onStart = {
                        binding.imageViewPoster.setImageResource(R.drawable.ic_access_time)
                    },
                    onSuccess = { poster ->
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewPoster.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imageViewPoster.setImageDrawable(poster)
                    },
                    onError = {
                        binding.progressBar.visibility = View.GONE
                        binding.imageViewPoster.setImageResource(R.drawable.ic_load_error)
                    }
                )
                .build()
            context.imageLoader.enqueue(imageRequest)
            binding.textViewTitle.text = movie.title
        }
    }

    interface RecyclerViewHomeClickListener {
        fun clickOnItem(data: Movie, card: View)
    }
}