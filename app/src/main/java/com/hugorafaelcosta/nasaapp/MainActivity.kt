package com.hugorafaelcosta.nasaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hugorafaelcosta.nasaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startDataFragment()
    }

    private fun startDataFragment() {
        val dataFragment = DataImageFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, dataFragment)
            .commit()
    }

}