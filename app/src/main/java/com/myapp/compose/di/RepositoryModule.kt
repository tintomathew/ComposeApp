package com.myapp.compose.di

import com.myapp.compose.repository.RestaurantRepo
import com.myapp.compose.service.RestaurantApiService
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