package com.myapp.compose.service

import com.myapp.compose.model.RestaurantDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApiService {
    @GET("bypostcode/{postCode}")
    suspend fun getRestaurantDetails(
        @Path("postCode") postCode: String
    ): Response<RestaurantDetails>
}
