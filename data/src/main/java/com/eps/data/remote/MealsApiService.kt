package com.eps.data.remote

import com.eps.domain.model.CategoryResponse
import retrofit2.http.GET

interface MealsApiService {
    @GET("categories.php")
    suspend fun getMeals(): CategoryResponse
}