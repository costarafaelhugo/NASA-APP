package com.hugorafaelcosta.nasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hugorafaelcosta.nasaapp.adapter.MainAdapter
import com.hugorafaelcosta.nasaapp.databinding.ActivityMainBinding
import com.hugorafaelcosta.nasaapp.rest.RetrofitService
import com.hugorafaelcosta.nasaapp.viewmodel.main.MainViewModel
import com.hugorafaelcosta.nasaapp.viewmodel.main.MainViewModelFactory
import com.hugorafaelcosta.repositories.MainRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()

    private val adapter = MainAdapter{

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java
        )

        binding.recyclerview.adapter = adapter

    }
}