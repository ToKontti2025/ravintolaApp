package com.example.ravintolaapp.data

import com.example.ravintolaapp.data.dto.RatingDto
import com.example.ravintolaapp.data.dto.RestaurantDto
import com.example.ravintolaapp.data.dto.RestaurantWithAvgRatingDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantApiService {

    // gets all restaurants with their average ratings
    @GET("/api/restaurants/ratings")
    suspend fun getRestaurantsWithAvgRatings(): List<RestaurantWithAvgRatingDto>

    // gets all ratings for a specific restaurant
    @GET("/api/restaurants/{resid}/ratings")
    suspend fun getRatingsForRestaurant(
        @Path("resid") restaurantId: Int
    ): List<RatingDto>

    // gets a single restaurant by id
    @GET("/api/restaurants/{resid}")
    suspend fun getRestaurant(
        @Path("resid") restaurantId: Int
    ): RestaurantDto
}