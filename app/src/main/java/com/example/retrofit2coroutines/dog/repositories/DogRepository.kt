package com.example.retrofit2coroutines.dog.repositories

import com.example.retrofit2coroutines.dog.dto.DogDto


interface DogRepository {
   suspend fun searchDogByBreed(breed: String): Result<DogDto>
}