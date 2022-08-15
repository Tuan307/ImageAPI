package com.example.imageapi.network

import com.example.imageapi.model.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    suspend fun getAllImage(@Query("client_id") id: String): Response<List<ImageModel>>
}