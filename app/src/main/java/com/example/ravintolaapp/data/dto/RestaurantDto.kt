package com.example.ravintolaapp.data.dto

data class RestaurantDto(
    val id: Int,
    val name: String,
    val address: String,
    val type: String,
    val priceLevel: String,
    val imageUrl: String
)