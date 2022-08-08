package com.hugorafaelcosta.nasaapp.dataRepository

import com.hugorafaelcosta.nasaapp.interfaceApi.ApiInterface

class DataMainRepository {
    fun getJoke() = ApiInterface.getInstance().getData()
}