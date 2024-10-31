package com.example.retrofit2coroutines.dog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2coroutines.R

class DogAdapter : RecyclerView.Adapter<DogViewHolder>() {

    private var dogImages: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_dog_image, parent, false
        )
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = dogImages[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dogImages.size

    fun setDogImages(dogImageList: List<String>) {
        dogImages = dogImageList
        notifyDataSetChanged()
    }
}