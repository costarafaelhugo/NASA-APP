package com.hugorafaelcosta.nasaapp.viewmodel.main

import androidx.lifecycle.ViewModel
import com.hugorafaelcosta.nasaapp.model.ImageData
import com.hugorafaelcosta.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    fun getAllImageDatas() {

        val request = repository.getAllImagesDatas()
        request.enqueue(object  : Callback<List<ImageData>>{
            override fun onResponse(
                call: Call<List<ImageData>>,
                response: Response<List<ImageData>>
            ) {

            }

            override fun onFailure(call: Call<List<ImageData>>, t: Throwable) {

            }

        })

    }
}