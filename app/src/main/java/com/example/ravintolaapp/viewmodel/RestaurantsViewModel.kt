package com.example.ravintolaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ravintolaapp.data.RestaurantApiService
import com.example.ravintolaapp.data.dto.RestaurantWithAvgRatingDto
import com.example.ravintolaapp.data.dto.RatingDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val apiService: RestaurantApiService
) : ViewModel() {

    // list of restaurants with avg rating
    private val _restaurants = MutableStateFlow<List<RestaurantWithAvgRatingDto>>(emptyList())
    val restaurants: StateFlow<List<RestaurantWithAvgRatingDto>> = _restaurants

    // ratings for selected restaurant
    private val _ratings = MutableStateFlow<List<RatingDto>>(emptyList())
    val ratings: StateFlow<List<RatingDto>> = _ratings

    // load all restaurants from backend
    fun loadRestaurants() {
        viewModelScope.launch {
            try {
                _restaurants.value = apiService.getRestaurantsWithAvgRatings()
            } catch (e: Exception) {
                // you could add error handling here
            }
        }
    }

    // load all ratings for one restaurant
    fun loadRatings(restaurantId: Int) {
        viewModelScope.launch {
            try {
                _ratings.value = apiService.getRatingsForRestaurant(restaurantId)
            } catch (e: Exception) {
                // you could add error handling here too
            }
        }
    }
}
