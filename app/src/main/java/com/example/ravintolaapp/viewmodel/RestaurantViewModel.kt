package com.example.ravintolareviewapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ravintolaapp.data.dto.RatingDto
import com.example.ravintolaapp.data.RestaurantApiService
import com.example.ravintolaapp.data.dto.RestaurantDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    private val apiService: RestaurantApiService
) : ViewModel() {

    private val _restaurant = MutableStateFlow<RestaurantDto?>(null)
    val restaurant: StateFlow<RestaurantDto?> = _restaurant

    private val _ratings = MutableStateFlow<List<RatingDto>>(emptyList())
    val ratings: StateFlow<List<RatingDto>> = _ratings

    fun loadRestaurantAndRatings(restaurantId: Int) {
        viewModelScope.launch {
            try {
                _restaurant.value = apiService.getRestaurant(restaurantId)
                _ratings.value = apiService.getRatingsForRestaurant(restaurantId)
            } catch (e: Exception) {
                // log or show error if needed
                _restaurant.value = null
                _ratings.value = emptyList()
            }
        }
    }
}
