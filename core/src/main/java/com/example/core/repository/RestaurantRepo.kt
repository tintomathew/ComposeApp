package com.example.core.di.repository

import com.example.core.di.common.Resource
import com.example.core.di.model.RestaurantDetails
import com.example.core.di.service.RestaurantApiService
import retrofit2.Response
import javax.inject.Inject

class RestaurantRepo @Inject constructor(private val restaurantApiService: RestaurantApiService) {
    suspend fun getRestaurantDetails(
        postCode: String
    ): Resource<RestaurantDetails> {
        return responseToResource(restaurantApiService.getRestaurantDetails(postCode))
    }

    private fun responseToResource(dataModel: Response<RestaurantDetails>): Resource<RestaurantDetails> {
        if (dataModel.isSuccessful) {
            dataModel.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(dataModel.message())
    }
}