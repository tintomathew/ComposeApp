package com.myapp.compose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.compose.model.Restaurant
import com.myapp.compose.repository.RestaurantRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val restaurantRepo: RestaurantRepo) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Restaurant>())
    val state: StateFlow<List<Restaurant>>
        get() = _state
    fun getRestaurants(text: String) {
        viewModelScope.launch {
            restaurantRepo.getRestaurantDetails(text).data?.Restaurants?.let {item->
                _state.update { item }
                Log.d("Respose::::", ":::$item")
            }
        }
    }
}