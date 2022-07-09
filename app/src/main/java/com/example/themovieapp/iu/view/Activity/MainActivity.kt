package com.example.themovieapp.iu.view.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.themovieapp.databinding.ActivityMainBinding
import com.example.themovieapp.iu.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setObservers()
        mainViewModel.getMovie()
    }

    private fun setObservers() {
        mainViewModel.isSuccess.observe(this, { isSuccess ->
            if (isSuccess) {
                Log.e(" Sirve", "Hola")
            } else {
                Log.e("NoSirve", "Hola")
            }
        })
    }
}