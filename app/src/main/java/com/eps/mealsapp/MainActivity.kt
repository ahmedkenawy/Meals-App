package com.eps.mealsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.eps.mealsapp.adapter.MealsAdapter
import com.eps.mealsapp.databinding.ActivityMainBinding
import com.eps.mealsapp.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MealsViewModel by viewModels()

    //    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        viewModel.getMeals()
        val rv = findViewById<RecyclerView>(R.id.RV)
        val mealsAdapter = MealsAdapter()

        lifecycleScope.launch {
            viewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
                Log.d("MealsApp", "onCreate: ${it?.categories}")
                rv.adapter = mealsAdapter
            }
        }
    }
}