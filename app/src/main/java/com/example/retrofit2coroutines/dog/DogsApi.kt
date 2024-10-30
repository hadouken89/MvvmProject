package com.example.retrofit2coroutines.dog

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface DogsApi {
    @GET()
    suspend fun getDogsByBreeds(@Url url: String): Response<DogDto>
}