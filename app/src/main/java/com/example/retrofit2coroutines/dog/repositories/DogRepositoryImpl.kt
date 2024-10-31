package com.example.retrofit2coroutines.dog.repositories

import com.example.retrofit2coroutines.dog.dto.DogDto
import com.example.retrofit2coroutines.dog.api.DogsApi


class DogRepositoryImpl(
    private val dogsApi: DogsApi
) : DogRepository{

    override suspend fun searchDogByBreed(breed: String): Result<DogDto> {
       return try {
           val response = dogsApi.getDogsByBreeds("$breed/images")
           if (response.isSuccessful) {
               response.body()?.let {
                   Result.Success(it)
               } ?: Result.Error(Exception("User not found"))
           } else {
               Result.Error(Exception("Error: ${response.code()}"))
           }

       }catch (e: Exception){
           Result.Error(e)
       }
    }
}


sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
