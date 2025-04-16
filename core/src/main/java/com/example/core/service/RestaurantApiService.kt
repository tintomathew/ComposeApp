package com.example.core.di.service

import com.example.core.di.model.RestaurantDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApiService {
    @GET("bypostcode/{postCode}")
    suspend fun getRestaurantDetails(
        @Path("postCode") postCode: String
    ): Response<RestaurantDetails>
}
