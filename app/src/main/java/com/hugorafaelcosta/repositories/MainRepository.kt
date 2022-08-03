package com.hugorafaelcosta.repositories

import com.hugorafaelcosta.nasaapp.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllImagesDatas() = retrofitService.getImageData()

}