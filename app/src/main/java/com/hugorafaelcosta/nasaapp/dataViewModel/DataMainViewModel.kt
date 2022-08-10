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

    private val explanationLiveData = MutableLiveData<String>()
    private val copyrightLiveData = MutableLiveData<String>()
    private val imageHDR = MutableLiveData<String>()

    val explanation_liveData: LiveData<String> = explanationLiveData
    val copyright_liveData: LiveData<String> = copyrightLiveData
    val image_HDR: LiveData<String> = imageHDR

    val repository = DataMainRepository()
    val errorMessage = MutableLiveData<String>()

    fun getDataImages() {

        val request = repository.getData()

        request.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, request: Response<DataModel>?) {
                if (request?.code() == 200) {
                    val dataImage = request.body()
                    explanationLiveData.postValue(dataImage?.explanation)
                    copyrightLiveData.postValue(dataImage?.copyright)
                    imageHDR.postValue(dataImage?.image)
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

