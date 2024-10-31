package com.example.retrofit2coroutines.dog

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit2coroutines.databinding.ItemDogImageBinding

class DogViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDogImageBinding.bind(view)

    fun bind(dogImage: String){

        Glide.with(binding.imgDog.context).load(dogImage).into(binding.imgDog)

    }

}