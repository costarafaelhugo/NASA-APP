package com.hugorafaelcosta.nasaapp.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val image: String
)
