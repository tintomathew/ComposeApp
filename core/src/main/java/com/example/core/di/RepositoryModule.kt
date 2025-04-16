package com.example.core.di

import com.example.core.di.repository.RestaurantRepo
import com.example.core.di.service.RestaurantApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRestaurantRepository(restaurantApiService: RestaurantApiService): RestaurantRepo {
        return RestaurantRepo(restaurantApiService)
    }
}