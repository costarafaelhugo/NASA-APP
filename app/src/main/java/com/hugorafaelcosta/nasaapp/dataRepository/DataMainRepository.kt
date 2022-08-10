package com.hugorafaelcosta.nasaapp.dataRepository

import com.hugorafaelcosta.nasaapp.interfaceApi.ApiInterface

class DataMainRepository {
    fun getData() = ApiInterface.getInstance().getData()
}