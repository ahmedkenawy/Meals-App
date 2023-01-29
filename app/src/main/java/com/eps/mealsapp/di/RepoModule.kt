package com.eps.mealsapp.di

import com.eps.data.remote.MealsApiService
import com.eps.data.repo.MealsRepoImpl
import com.eps.domain.repo.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: MealsApiService): MealsRepository {
        return MealsRepoImpl(apiService)
    }
}