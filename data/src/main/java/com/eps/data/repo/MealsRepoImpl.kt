package com.eps.data.repo

import com.eps.data.remote.MealsApiService
import com.eps.domain.model.CategoryResponse
import com.eps.domain.repo.MealsRepository

class MealsRepoImpl (private val mealsApiService: MealsApiService):MealsRepository{
    override fun getMealsFromRemote(): CategoryResponse =mealsApiService.getMeals()
}