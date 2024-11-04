package com.example.retrofit2coroutines.dog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit2coroutines.dog.repositories.DogRepository
import kotlinx.coroutines.launch
import com.example.retrofit2coroutines.dog.repositories.Result

class DogViewModel(
    private val dogRepository: DogRepository
) : ViewModel() {

    private val mutableDogList = MutableLiveData<List<String>>()
    val dogList get() = mutableDogList

    fun getDogByBreed(breed: String) {
        viewModelScope.launch {
            when (val result = dogRepository.searchDogByBreed(breed)) {
                is Result.Success -> {
                    mutableDogList.value = result.data?.images
                }

                is Result.Error -> {
                    mutableDogList.value = emptyList()
                }
            }
        }
    }
}