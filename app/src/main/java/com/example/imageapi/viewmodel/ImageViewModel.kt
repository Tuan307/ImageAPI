package com.example.imageapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageapi.model.ImageModel
import com.example.imageapi.network.ApiClient
import com.example.imageapi.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImageViewModel : ViewModel() {

    private val retrofit: ApiService = ApiClient.getApiClient().create(ApiService::class.java)
    private val imageList: MutableLiveData<List<ImageModel>> = MutableLiveData()
    fun getImageList() = imageList as LiveData<List<ImageModel>>

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            val id = "nXy0CSTdrCsyNOs6OOM7ydHUkrbmb3O-TAJM4YEl4gs"
            val response = retrofit.getAllImage(id)
            if (response.isSuccessful) {
                imageList.postValue(response.body())
            }
        }
    }

}