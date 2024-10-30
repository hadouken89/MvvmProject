package com.example.retrofit2coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.retrofit2coroutines.databinding.ActivityMainBinding
import com.example.retrofit2coroutines.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        searchDogByBreed("vizsla")
    }

    private fun searchDogByBreed(breed: String) {
        CoroutineScope(Dispatchers.IO).launch{
            val response = RetrofitInstance.dogApi.getDogsByBreeds("$breed/images")
            val dogDto = response.body()
            if (response.isSuccessful) {
                // do something
            }else{
                // handle server response
            }
        }
    }
}
