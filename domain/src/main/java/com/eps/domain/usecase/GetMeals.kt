package com.eps.domain.usecase

import com.eps.domain.repo.MealsRepository

class GetMeals(private val mealsRepository: MealsRepository) {

    suspend operator fun invoke() = mealsRepository.getMealsFromRemote()

}