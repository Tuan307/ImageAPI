package com.example.imageapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private val base_url = "https://api.unsplash.com/"

        //photos/?client_id=nXy0CSTdrCsyNOs6OOM7ydHUkrbmb3O-TAJM4YEl4gs
        fun getApiClient(): Retrofit {
            return Retrofit.Builder().baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}