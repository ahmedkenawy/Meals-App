package com.eps.mealsapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eps.domain.model.CategoryResponse
import com.eps.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMeals
) : ViewModel() {

    private val _categories: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val categories :StateFlow<CategoryResponse?> = _categories.asStateFlow()

    fun getMeals() {
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            } catch (ex: java.lang.Exception) {
                Log.d("MealsApp", "getMeals: ${ex.message.toString()}")
            }
        }
    }
}