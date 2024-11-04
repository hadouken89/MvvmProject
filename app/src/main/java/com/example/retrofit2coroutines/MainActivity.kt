package com.example.retrofit2coroutines

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2coroutines.databinding.ActivityMainBinding
import com.example.retrofit2coroutines.dog.DogAdapter
import com.example.retrofit2coroutines.dog.repositories.DogRepositoryImpl
import com.example.retrofit2coroutines.dog.viewmodel.DogViewModel
import com.example.retrofit2coroutines.dog.viewmodel.DogViewModelFactory
import com.example.retrofit2coroutines.network.RetrofitInstance

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dogAdapter: DogAdapter by lazy {
        DogAdapter()
    }

    //TODO: implement dagger
    private val dogViewModel: DogViewModel by viewModels {
        DogViewModelFactory(DogRepositoryImpl(RetrofitInstance.dogApi))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpView()
        setUpObservers()
    }

    private fun setUpObservers() {
        dogViewModel.dogList.observe(this) { dogImageList ->
            dogAdapter.setDogImages(dogImageList)
        }
    }

    private fun setUpView() {
        initDogRecyclerView()

        binding.searchViewDog.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    dogViewModel.getDogByBreed(query)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }

    private fun initDogRecyclerView() {
        binding.recyclerViewDogs.apply {
            adapter = dogAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }
}
