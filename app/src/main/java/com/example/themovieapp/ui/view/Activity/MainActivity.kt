package com.example.themovieapp.ui.view.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.data.model.Movie
import com.example.themovieapp.databinding.ActivityMainBinding
import com.example.themovieapp.ui.view.adapter.MainAdapter
import com.example.themovieapp.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainAdapter.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainAdapter: MainAdapter

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        mainViewModel.getMovie()
        setMainAdapter()
    }
    private fun setMainAdapter() {
        mainAdapter = MainAdapter(this)
        binding.recyclerViewMain.adapter = mainAdapter
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewMain.layoutManager = linearLayoutManager
        mainAdapter.notifyDataSetChanged()
    }

    private fun setObservers() {
        mainViewModel.isSuccess.observe(this, { isSuccess ->
            Log.e("Hola", "Aqui esta: $isSuccess")
        })
    }

    override fun onClick(movie: Movie) {

    }
}