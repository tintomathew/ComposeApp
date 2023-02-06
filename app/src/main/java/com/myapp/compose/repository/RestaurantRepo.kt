package com.myapp.compose.repository

import com.myapp.compose.common.Resource
import com.myapp.compose.model.RestaurantDetails
import com.myapp.compose.service.RestaurantApiService
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