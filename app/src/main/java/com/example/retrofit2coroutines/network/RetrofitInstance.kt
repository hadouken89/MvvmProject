package com.example.retrofit2coroutines.network

import com.example.retrofit2coroutines.dog.api.DogsApi
import com.example.retrofit2coroutines.dog.constants.DogsApiConstants.DOGS_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    val dogApi: DogsApi by lazy {
        Retrofit.Builder()
            .baseUrl(DOGS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogsApi::class.java)
    }
}