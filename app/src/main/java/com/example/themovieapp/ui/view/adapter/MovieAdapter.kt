package com.example.themovieapp.ui.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.data.model.MovieModel
import com.example.themovieapp.databinding.ItemMainBinding

import android.widget.ImageView
import coil.imageLoader
import coil.request.ImageRequest
import coil.transform.BlurTransformation
import com.example.themovieapp.utils.Constants.IMAGE_URL


class MovieAdapter(
    private val recyclerViewHome: RecyclerViewHomeClickListener,
    private val context: Context
) :
    RecyclerView.Adapter<MovieAdapter.MainViewHolder>() {

    private lateinit var recyclerView: RecyclerView
    private var movieModels: List<MovieModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMainBinding.inflate(
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

    fun submitList(itemList: List<MovieModel>) {
        movieModels = itemList
        notifyDataSetChanged()
    }

    class MainViewHolder(private var binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieModel: MovieModel, context: Context) {
            val imageRequest = ImageRequest.Builder(context)
                .data("$IMAGE_URL${movieModel.poster}")
                .crossfade(true)
                .transformations(
                    listOf(
                        BlurTransformation(context, 25f)
                    )
                )
                .size(1280, 720)
                .target(
                    onStart = {

                    },
                    onSuccess = { poster ->
                        binding.imageViewPoster.scaleType = ImageView.ScaleType.CENTER_CROP
                        binding.imageViewPoster.setImageDrawable(poster)
                    },
                    onError = {
                        Log.e("hola", "onError: $it")
                    }
                )
                .build()
            context.imageLoader.enqueue(imageRequest)
            binding.textViewTitle.text = movieModel.title
        }
    }

    interface RecyclerViewHomeClickListener {
        fun clickOnItem(data: MovieModel, card: View)
    }
}