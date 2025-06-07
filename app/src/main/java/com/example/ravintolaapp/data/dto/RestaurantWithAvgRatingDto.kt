package com.example.ravintolaapp.data.dto

data class RestaurantWithAvgRatingDto(

    val id: Int,
    val name: String,
    val address: String,
    val type: String,
    val priceLevel: String,
    val imageUrl: String,
    val avgRating: Float,
    val reviewCount: Int
)