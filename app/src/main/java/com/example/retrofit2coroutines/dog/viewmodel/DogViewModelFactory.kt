package com.example.retrofit2coroutines.dog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit2coroutines.dog.repositories.DogRepository

class DogViewModelFactory(
    private val dogRepository: DogRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DogViewModel::class.java)){
            return DogViewModel(dogRepository) as T
        }
        throw  IllegalArgumentException("unknown viemodel class")
    }
}