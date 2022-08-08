package com.hugorafaelcosta.nasaapp.dataViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hugorafaelcosta.nasaapp.dataRepository.DataMainRepository
import com.hugorafaelcosta.nasaapp.models.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataMainViewModel : ViewModel() {

    private val liveData = MutableLiveData<String>()
    val _liveData: LiveData<String> = liveData
    val repository = DataMainRepository()
    val errorMessage = MutableLiveData<String>()

    fun getDataImages() {

        val request = repository.getJoke()

        request.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, request: Response<DataModel>?) {
                if (request?.code() == 200) {
                    val dataImage = request.body()
                    liveData.postValue(dataImage?.explanation)
                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                if (t != null) {
                    errorMessage.postValue(t.message)
                }
            }
        })
    }
}

