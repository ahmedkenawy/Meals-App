package com.eps.mealsapp.di

import com.eps.domain.repo.MealsRepository
import com.eps.domain.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(mealsRepository: MealsRepository): GetMeals {
        return GetMeals(mealsRepository)
    }

}