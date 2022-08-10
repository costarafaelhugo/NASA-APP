package com.hugorafaelcosta.nasaapp.interfaceApi

import com.hugorafaelcosta.nasaapp.models.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/planetary/apod?api_key=Wb2urdrXn0DtfeRbbXUpqOtH3sgiXRKu7TEE96dm")
    fun getData(): Call<DataModel>

    companion object {
        private val retrofitService : ApiInterface by lazy {
            val retrofit = Retrofit.Builder()

            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

            retrofit.create(ApiInterface::class.java)
        }

        fun getInstance(): ApiInterface{
            return retrofitService
        }
    }
}