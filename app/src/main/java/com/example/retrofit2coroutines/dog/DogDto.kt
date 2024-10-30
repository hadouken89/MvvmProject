package com.example.retrofit2coroutines.dog

import com.google.gson.annotations.SerializedName

data class DogDto(
    @SerializedName("message")
    var images: List<String>,
    @SerializedName("status")
    var status: String
)
