package com.hugorafaelcosta.nasaapp.rest

import com.hugorafaelcosta.nasaapp.model.ImageData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("apod?api_key=Wb2urdrXn0DtfeRbbXUpqOtH3sgiXRKu7TEE96dm")
    fun getImageData(): Call<List<ImageData>>

    companion object {
        private val retrofitService: RetrofitService by lazy{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/planetary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService{
            return retrofitService
        }
    }

    //https://api.nasa.gov/planetary/
    ///apod?api_key=Wb2urdrXn0DtfeRbbXUpqOtH3sgiXRKu7TEE96dm
}