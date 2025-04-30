package com.myapp.compose.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.compose.R
import com.example.core.di.StringResource
import com.example.core.di.model.Restaurant
import com.example.core.di.repository.RestaurantRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val restaurantRepo: RestaurantRepo,
                                        val stringResource: StringResource
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Restaurant>())
    val state: StateFlow<List<Restaurant>>
        get() = _state

    var selectedRestaurant by mutableStateOf<Restaurant?>(null)
        private set

    fun selectRestaurant(restaurant: Restaurant) {
        selectedRestaurant = restaurant
    }

    fun getRestaurants(text: String) {
        viewModelScope.launch {
            restaurantRepo.getRestaurantDetails(text).data?.Restaurants?.let { item ->
                _state.update { item }
                Log.d("Respose::::", ":::$item"+stringResource.get(R.string.show_more))
            }
        }
    }

    fun getStringResource() {
        Log.d("String:::","::"+stringResource.get(R.string.show_more))
    }
}