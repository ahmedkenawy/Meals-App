package com.eps.domain.repo

import com.eps.domain.model.CategoryResponse

interface MealsRepository {
    suspend fun getMealsFromRemote(): CategoryResponse
}